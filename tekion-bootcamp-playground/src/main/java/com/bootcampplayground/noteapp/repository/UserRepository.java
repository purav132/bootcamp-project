package com.bootcampplayground.noteapp.repository;

import com.bootcampplayground.noteapp.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmail(String email);

    @Transactional
    @Modifying
    @Query(value="update users u set u.firstName = :firstName, u.lastName = :lastName where u.email = :email")
    void setUserDetails(@Param(value = "firstName") String firstName,@Param(value = "lastName") String lastName,@Param(value = "email") String email);
    @Transactional
    @Modifying
    @Query(value="update users u set u.password = :password where u.email = :email")
    void setUserPassword(@Param(value = "password") String password,@Param(value = "email") String email);
}
