package com.bootcampplayground.noteapp.controller;

import com.bootcampplayground.noteapp.models.Otp;
import com.bootcampplayground.noteapp.services.OtpService;
import com.bootcampplayground.noteapp.services.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@RequiredArgsConstructor
public class OtpController {

    private final OtpService otpService;
    private final UserService userService;

    @PostMapping("/validateOtp")
    public ResponseEntity otpChecker(@RequestBody Otp toCheckOtp) {
        if(otpService.validateOtp(toCheckOtp.getEmail(), toCheckOtp.getOtp()) == true){
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
            //redirect to welcome page
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            //redirect to this page only with error message
            //this method is also used for validating otp send for forgot password
        }
    }

    @PostMapping("/sendOtp")
    public ResponseEntity otpSender(@RequestBody Otp toGenerateOtp) {
        System.out.println("email: "+ toGenerateOtp.getEmail());
        if(userService.checkUser(toGenerateOtp.getEmail()) == true) {
            Thread thread=new Thread(()->{
                otpService.sendOtp(toGenerateOtp.getEmail());
            });
            thread.start();
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
            //redirect to same page with another attribute of enter otp along with email in href
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            //show error no user found
        }
    }
}
