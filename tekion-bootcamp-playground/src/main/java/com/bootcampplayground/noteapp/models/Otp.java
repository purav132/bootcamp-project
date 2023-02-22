package com.bootcampplayground.noteapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Otp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String otp;

    public Otp(String email, String otp) {
        this.email = email;
        this.otp = otp;
    }
}
