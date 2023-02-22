package com.bootcampplayground.noteapp.services;

import com.bootcampplayground.noteapp.models.Otp;
import com.bootcampplayground.noteapp.repository.OtpRepository;
import com.bootcampplayground.noteapp.util.SmtpUtilService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class OtpService {


    private final SmtpUtilService smtpUtilService;
    private final OtpRepository otpRepository;
    private final UserService userService;

    public String generateOtp(String email) {
        Random rand = new Random();
        String otp = String.format("%04d", rand.nextInt(10000));
        try {
            otpRepository.delete(otpRepository.findByEmail(email));
        } catch (Exception e) {
            System.out.println("New Entry");
        }
        otpRepository.save(new Otp(email, otp));
        return otp;
    }

    public void sendOtp(String email) {
        String otp = generateOtp(email);
        String message = "Your Otp for verification is: "+ otp;
        smtpUtilService.sendEmail(email, message, "Verification");
    }

    public boolean validateOtp(String email, String enteredOtp) {
        Otp otp = otpRepository.findByEmail(email);
        if (otp.getOtp().equals(enteredOtp) == true) {
            userService.setVerifiedTrue(email);
            return true;
        } else {
            return false;
        }
    }
}
