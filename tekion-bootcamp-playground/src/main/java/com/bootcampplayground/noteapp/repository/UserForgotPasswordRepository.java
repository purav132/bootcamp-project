package com.bootcampplayground.noteapp.repository;

import com.bootcampplayground.noteapp.models.UserForgotPassword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserForgotPasswordRepository extends JpaRepository<UserForgotPassword, Integer> {
    UserForgotPassword findByHashedEmail(String hashedEmail);
    UserForgotPassword findByEmail(String email);
}
