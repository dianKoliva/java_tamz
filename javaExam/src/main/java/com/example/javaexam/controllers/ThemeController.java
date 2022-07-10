package com.example.javaexam.controllers;

import com.example.javaexam.Models.School;
import com.example.javaexam.Models.Student;
import com.example.javaexam.repositiories.SchoolRepo;
import com.example.javaexam.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class ThemeController {

    @Autowired
    SchoolService schoolService;
    @Autowired
    SchoolRepo schoolRepo;

    @GetMapping(path="/schools")
    public  String listSchools(Model model){
model.addAttribute("schools",schoolService.getSchool());
        return  "schools";
    }

    @GetMapping(path="/schools/new")
    public  String createSchool(Model model ){

        School school=new School();
        model.addAttribute("school",school);
        return "create_School";

    }

    @PostMapping("/schools")
    public  String saveSchool(@ModelAttribute("school") School school){
schoolService.createSchool(school);
return "redirect:/schools";
    }


    @GetMapping("/schools/edit/{id}")
    public String editSchool(@PathVariable Long id,Model model){
   Optional<School> schoolFound=schoolRepo.findById(id);
model.addAttribute("school",schoolFound.get());
return  "edit_School";

    }

    @PostMapping("/schools/{id}")
    public  String updateSchool(@PathVariable  Long id , @ModelAttribute("school") School school,Model model){
//        System.out.println("hey wanna edit");
//        Optional<School> existingSchool=schoolRepo.findById(id);
//        if(existingSchool.isPresent()){
//            existingSchool.get().setId(id);
//            existingSchool.get().setName(school.getName());
//            existingSchool.get().setLocation(school.getLocation());
//        }
    schoolService.updateSchool(id,school);
        return "redirect:/schools";
    }

    @GetMapping("/schools/delete/{id}")
    public  String deleteSchool(@PathVariable Long id){
        schoolRepo.deleteById(id);
        return "redirect:/schools";
    }
}
