package com.example.javaexam.controllers;

import com.example.javaexam.Models.Admin;
import com.example.javaexam.repositiories.AdminRepo;
import com.example.javaexam.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/admin")
public class AdimControllers {
    @Autowired
    AdminService adminService;

    @GetMapping
    public List<Admin> getAll(){
        return adminService.getAll();
    }
    @PostMapping("/register")
    public String register(@RequestBody Admin admin){
        return adminService.register(admin);
    }


}
