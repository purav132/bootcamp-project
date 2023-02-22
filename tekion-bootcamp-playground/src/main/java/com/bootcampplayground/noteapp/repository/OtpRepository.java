package com.bootcampplayground.noteapp.repository;

import com.bootcampplayground.noteapp.models.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepository extends JpaRepository<Otp, Integer> {
    Otp findByEmail(String email);
}
