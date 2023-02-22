package com.bootcampplayground.noteapp.models.responseModels;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
public class UserProfileDetails {
    private String firstName;
    private String lastName;
    private String email;
    private String imageUrl;
    private int earnings;

    public UserProfileDetails(String firstName, String lastName, String email, String imageUrl, int earnings) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.imageUrl = imageUrl;
        this.earnings = earnings;
    }
}
