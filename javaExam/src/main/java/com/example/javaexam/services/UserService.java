package com.example.javaexam.services;

import com.example.javaexam.Models.School;
import com.example.javaexam.Models.User;
import com.example.javaexam.repositiories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public String register(User user) {
        boolean exists = userRepo.existsByEmail(user.getEmail());
        if (exists) {
            return "user already exists";
        }
         userRepo.save(user);
        return "user created";
    }

    public String login(User user){
        boolean exists = userRepo.existsByEmail(user.getEmail());
        if(exists){
            Optional<User> user1=userRepo.findById(user.getId());
            if (user1.get().getPassword()==user.getPassword()){
   return "valid";
            }
            else{
                return  "invalid";
            }
        }

            return "invalid email";

    }

    public List<User> getUsers(){
    return   userRepo.findAll();

    }

}
