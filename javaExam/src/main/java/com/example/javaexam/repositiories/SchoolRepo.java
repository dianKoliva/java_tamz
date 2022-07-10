package com.example.javaexam.repositiories;

import com.example.javaexam.Models.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepo extends JpaRepository<School,Long> {
    boolean existsByName(String name);
    boolean existsById(Long id);
}
