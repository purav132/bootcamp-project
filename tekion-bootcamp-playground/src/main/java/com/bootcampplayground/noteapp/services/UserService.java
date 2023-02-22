package com.bootcampplayground.noteapp.services;

import com.bootcampplayground.noteapp.models.Otp;
import com.bootcampplayground.noteapp.models.User;
import com.bootcampplayground.noteapp.models.UserForgotPassword;
import com.bootcampplayground.noteapp.models.requestModels.EditUserPassword;
import com.bootcampplayground.noteapp.models.requestModels.EditUserProfile;
import com.bootcampplayground.noteapp.models.requestModels.LoginUser;
import com.bootcampplayground.noteapp.models.requestModels.SignUpUser;
import com.bootcampplayground.noteapp.repository.UserForgotPasswordRepository;
import com.bootcampplayground.noteapp.models.responseModels.CustomError;
import com.bootcampplayground.noteapp.models.responseModels.UserProfileDetails;
import com.bootcampplayground.noteapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder bCryptPasswordEncoder;

    private final UserForgotPasswordRepository userForgotPasswordRepository;

    public boolean checkUser(String email) {
        if(userRepository.findByEmail(email) != null)
            return true;
        return false;
    }

    public boolean checkUserCredentials(LoginUser loginUser) {
        User user = userRepository.findByEmail(loginUser.getEmail());
        if (user.getPassword().equals(loginUser.getPassword())) {
            return true;
        } else return false;
    }

    public void saveUser(SignUpUser signUpUser) {
        userRepository.save(new User(signUpUser.getFirstName(), signUpUser.getLastName(), signUpUser.getEmail(), signUpUser.getPassword(), null));
    }

    public UserProfileDetails getUserProfileDetails(String email) throws Exception {
        try {
            User user = userRepository.findByEmail(email);
            UserProfileDetails userProfileDetails = new UserProfileDetails(user.getFirstName(), user.getLastName(), user.getEmail(), user.getImageUrl(), 10);
            return userProfileDetails;
        } catch (Exception e) {
            throw e;
        }
    }

    public void editUserProfile(EditUserProfile editUserProfile, String email) throws Exception {
        try {
            if (editUserProfile.getFirstName() == null || editUserProfile.getFirstName().strip() == "")
                throw new CustomError(400, "Invalid Arguments", new Throwable());
            editUserProfile.setFirstName(editUserProfile.getFirstName().strip());
            editUserProfile.setLastName(editUserProfile.getLastName() != null ? editUserProfile.getLastName().strip() : "");

            userRepository.setUserDetails(editUserProfile.getFirstName(), editUserProfile.getLastName(), email);
        } catch (Exception e) {
            throw e;
        }
    }

    public void setVerifiedTrue(String email){
        User user = userRepository.findByEmail(email);
        user.setVerified(true);
        userRepository.save(user);
    }

    public void updateUser(String email,String password){
        User user=userRepository.findByEmail(email);
        user.setPassword(password);
        userRepository.save(user);
    }

    public String getHashedString(String email){
        Random rand = new Random();
        String randomString = String.format("%04d", rand.nextInt(10000))+email;
        String hashedString = bCryptPasswordEncoder.encode(randomString);
        return hashedString;
    }

    public void saveForgotHashedEmail(String email, String hashedEmail) {
        UserForgotPassword userForgotPassword = userForgotPasswordRepository.findByEmail(email);
        if(userForgotPassword == null){
            userForgotPasswordRepository.save(new UserForgotPassword(email, hashedEmail));
            return;
        }
        userForgotPassword.setHashedEmail(hashedEmail);
        userForgotPasswordRepository.save(userForgotPassword);
    }

    public boolean checkUserForgotPasswordEntry(String hashedEmail){
        UserForgotPassword userForgotPassword = userForgotPasswordRepository.findByHashedEmail(hashedEmail);
        if(userForgotPassword == null){
            return false;
        }
        userForgotPassword.setVerified(true);
        userForgotPassword.setHashedEmail(null);
        userForgotPasswordRepository.save(userForgotPassword);
        return true;
    }

    public void editUserPassword(EditUserPassword editUserPassword, String email) throws Exception {
        try {
            if (editUserPassword.getPassword() == null || editUserPassword.getPassword().strip() == "")
                throw new CustomError(400, "Invalid Arguments", new Throwable());
            editUserPassword.setPassword(editUserPassword.getPassword().strip());
            userRepository.setUserPassword(editUserPassword.getPassword(), email);
        } catch (Exception e) {
            throw e;
        }
    }

}
