package com.bootcampplayground.noteapp.models.requestModels;


import lombok.Data;

@Data
public class LoginUser {
    private String email;
    private String password;
    private String confirmPassword;

}
