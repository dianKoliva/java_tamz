package com.example.javaexam.Models;

import javax.persistence.*;

import com.example.javaexam.Gender;

@Entity
@Table
public class Student {

    @GeneratedValue
    @Id
    private Long id;
    private  String name;
    private int age;
    private Gender gender;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "school_id", referencedColumnName = "id")
    private School school;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}
