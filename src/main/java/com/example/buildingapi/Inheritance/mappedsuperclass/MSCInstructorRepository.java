package com.example.buildingapi.Inheritance.mappedsuperclass;

import com.example.buildingapi.Inheritance.singleclass.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MSCInstructorRepository extends JpaRepository<com.example.buildingapi.Inheritance.mappedsuperclass.Instructor, Long> {

    com.example.buildingapi.Inheritance.mappedsuperclass.Instructor save(com.example.buildingapi.Inheritance.mappedsuperclass.Instructor instructor);

    Instructor findInstructorById(Long id);
}
