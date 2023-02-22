package com.bootcampplayground.noteapp.models.requestModels;

import lombok.Data;

@Data
public class EditUserPassword {
    private String password;
    public EditUserPassword() {
    }

    public EditUserPassword(String password) {
        this.password = password;
    }
}
