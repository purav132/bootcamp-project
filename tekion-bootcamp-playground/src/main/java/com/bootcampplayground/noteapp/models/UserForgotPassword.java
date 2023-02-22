package com.bootcampplayground.noteapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserForgotPassword {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String email;
    @Column
    private String hashedEmail;
    @Column
    private boolean verified;


    public UserForgotPassword(String email, String hashedEmail){
        this.email = email;
        this.verified = false;
        this.hashedEmail = hashedEmail;
    }

}
