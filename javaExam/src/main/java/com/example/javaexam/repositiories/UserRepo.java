package com.example.javaexam.repositiories;

import com.example.javaexam.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

    boolean existsByEmail(String email);
}
