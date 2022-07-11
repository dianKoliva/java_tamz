package com.example.javaexam.services;

import com.example.javaexam.Models.Admin;
import com.example.javaexam.repositiories.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminRepo adminRepo;

    public List<Admin>getAll(){
        return adminRepo.findAll();
    }

    public String register(Admin admin){
        adminRepo.save(admin);
        return "saved";
    }
}
