package com.example.javaexam.controllers;

import com.example.javaexam.Models.User;
import com.example.javaexam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserContorllers {
    @Autowired
    UserService userService;

    @GetMapping("/get-all")
    public List<User> getUsers(){
        return  userService.getUsers();
    }

    @PostMapping("/register")
    public  String register(@RequestBody User user){
        return  userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return  userService.login(user);
    }



}
