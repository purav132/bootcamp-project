package com.bootcampplayground.noteapp.models.requestModels;

import lombok.Data;

@Data
public class EditUserProfile {
    private String firstName;
    private String lastName;

    public EditUserProfile() {
    }

    public EditUserProfile(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
