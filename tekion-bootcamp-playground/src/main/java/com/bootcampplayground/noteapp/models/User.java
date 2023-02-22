package com.bootcampplayground.noteapp.models;


import jakarta.persistence.*;
import lombok.*;

@Entity(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String firstName;
    @Column
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column
    private String imageUrl;

    @Column(nullable = false)
    private boolean verified;


    public User(String firstName, String lastName, String email, String password, String imageUrl) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageUrl = imageUrl;
        this.verified = false;
    }
}
