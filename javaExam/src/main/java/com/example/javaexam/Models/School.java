package com.example.javaexam.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class School {

    @Id
    @GeneratedValue
    private Long id;
    private  String name;
    private  String location;

    public School() {
    }

    public School(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public School(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}

