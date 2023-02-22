package com.bootcampplayground.noteapp.controller;

import com.bootcampplayground.noteapp.models.requestModels.EditUserPassword;
import com.bootcampplayground.noteapp.models.requestModels.EditUserProfile;
import com.bootcampplayground.noteapp.models.requestModels.LoginUser;
import com.bootcampplayground.noteapp.models.requestModels.SignUpUser;
import com.bootcampplayground.noteapp.models.responseModels.CustomError;
import com.bootcampplayground.noteapp.models.responseModels.ResponseMessage;
import com.bootcampplayground.noteapp.models.responseModels.UserProfileDetails;
import com.bootcampplayground.noteapp.services.OtpService;
import com.bootcampplayground.noteapp.services.UserService;
import com.bootcampplayground.noteapp.util.SmtpUtilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final OtpService otpService;

    private final SmtpUtilService smtpUtilService;

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody LoginUser loginUser) {
        if(userService.checkUser(loginUser.getEmail()) == false){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            //redirect to register page with error message
        }
        else if(userService.checkUserCredentials(loginUser) == false){
            return  ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            //redirect to login page with error message
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        //redirect to welcome page
    }


    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody SignUpUser signUpUser){
        System.out.println(signUpUser);
        if(userService.checkUser(signUpUser.getEmail()) == true){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
            //redirect to login page
        }

        if (signUpUser.getPassword().equals(signUpUser.getConfirmPassword())) {
            userService.saveUser(signUpUser);
            Thread thread = new Thread(() -> {
                otpService.sendOtp(signUpUser.getEmail());
                System.out.println("Inside Thread");
            });
            thread.start();
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
            // redirect to otp page
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            //redirect to sign up page
        }
    }

    @PostMapping("/resetPassword")
    public ResponseEntity resetPassword(@RequestBody LoginUser loginUser)
    {
        if(loginUser.getPassword().equals(loginUser.getConfirmPassword())==true){
            userService.updateUser(loginUser.getEmail(),loginUser.getPassword());
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/forgotPassword")
    public ResponseEntity<?> forgotPassword(@RequestBody LoginUser loginUser){
        if(userService.checkUser(loginUser.getEmail()) == false){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        String hashedEmail = userService.getHashedString(loginUser.getEmail());
        int len = hashedEmail.length();
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++){
            if(hashedEmail.charAt(i)=='/')
                sb.append('a');
            else
                sb.append(hashedEmail.charAt(i));
        }
        String newHashedEmail=sb.toString();
        userService.saveForgotHashedEmail(loginUser.getEmail(), newHashedEmail);
        Thread thread=new Thread(()->{
            smtpUtilService.sendEmail(loginUser.getEmail(),
                    "To confirm your account, please click here : \n\n" + "http" +
                                                            "://localhost:8080/verifyForgotPassword/"+newHashedEmail,
                    "Forgot Password Verification");
        });
        thread.start();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/verifyForgotPassword/{hashedEmail}")
    public ResponseEntity<?> checkUserForgotPasswordLink(@PathVariable String hashedEmail){
//        System.out.println(hashedEmail);
        if(userService.checkUserForgotPasswordEntry(hashedEmail) == true){
            return ResponseEntity.ok("Verified User");
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        //redirect to reset password with the email
    }

    @GetMapping(path = "/getUserProfile")
    public ResponseEntity<?> getUserProfileDetails(@RequestParam String email) throws Exception {

        try {
            UserProfileDetails userProfileDetails = userService.getUserProfileDetails(email);
            return ResponseEntity.ok(userProfileDetails);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ResponseMessage(false, e.getMessage()));
        }
    }

    @PostMapping(path = "/editUserProfile")
    public ResponseEntity<?> editUserProfile(@RequestBody EditUserProfile editUserProfile, @RequestParam String email) throws Exception {
        try {
            userService.editUserProfile(editUserProfile, email);
            return ResponseEntity.ok(new ResponseMessage(true, "Successfully Updated User profile"));
        } catch (Exception e) {
            if (e instanceof CustomError)
                return ResponseEntity.status(((CustomError) e).getStatus()).body(new ResponseMessage(false, e.getMessage()));
            return ResponseEntity.internalServerError().body(new ResponseMessage(false, "Internal Server Error"));
        }
    }

    @PostMapping(path = "/editUserPassword")
    public ResponseEntity<?> editUserPassword(@RequestBody EditUserPassword editUserPassword, @RequestParam String email) throws Exception {
        try {
            userService.editUserPassword(editUserPassword, email);
            return ResponseEntity.ok(new ResponseMessage(true, "Successfully Updated User password"));
        } catch (Exception e) {
            if (e instanceof CustomError)
                return ResponseEntity.status(((CustomError) e).getStatus()).body(new ResponseMessage(false, e.getMessage()));
            return ResponseEntity.internalServerError().body(new ResponseMessage(false, "Internal Server Error"));
        }
    }
}
