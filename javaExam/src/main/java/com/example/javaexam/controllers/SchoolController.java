package com.example.javaexam.controllers;

import com.example.javaexam.Models.School;
import com.example.javaexam.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping(path="/api/schools")
public class SchoolController {

    @Autowired
    SchoolService schoolService;


    @PostMapping(path="/register")
    public ResponseEntity<?> createSchool(@RequestBody School school ){

         School school1=schoolService.createSchool(school);


return  ResponseEntity.ok(school1);
    }



@GetMapping(path="/get-all")
    public  ResponseEntity<?> getSchools(){
        List<School> schools =schoolService.getSchool();
        return  ResponseEntity.ok(schools);
    }

}
