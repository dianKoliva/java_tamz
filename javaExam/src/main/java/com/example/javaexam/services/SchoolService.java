package com.example.javaexam.services;

import com.example.javaexam.Models.School;
import com.example.javaexam.repositiories.SchoolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    @Autowired
    public SchoolRepo schoolRepo;

    public School createSchool(School school){
        boolean exists=schoolRepo.existsByName(school.getName());
        if(exists){
            throw new BadRequestException(String.format("School with name '%s' already exists", school.getName()));
        }
       return schoolRepo.save(school);
    }

    public List<School> getSchool(){
        return schoolRepo.findAll();
    }

    @Transactional
    public  String updateSchool(Long id,School school) {
        Optional<School> found = schoolRepo.findById(id);
        if (found.isPresent()) {
            if (school.getName() != null && school.getName().length() > 0) {

                found.get().setName(school.getName());

            }

            if (school.getLocation() != null && school.getLocation().length() > 0) {
                found.get().setLocation(school.getLocation());

            }
            return "updated";
        } else {
            return "school not found";
        }
    }

    public String deleteOne(long id) {
        if(schoolRepo.existsById(id)){
            deleteOne(id);
            return ("deleted");
        }
        else{
            return "school not found";
        }

    }



}
