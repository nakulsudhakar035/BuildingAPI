package com.example.buildingapi.Inheritance.mappedsuperclass;

import com.example.buildingapi.Inheritance.singleclass.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MSCMentorRepository extends JpaRepository<com.example.buildingapi.Inheritance.mappedsuperclass.Mentor, Long> {

    com.example.buildingapi.Inheritance.mappedsuperclass.Mentor save(com.example.buildingapi.Inheritance.mappedsuperclass.Mentor mentor);

    Mentor findMentorById(Long id);
}
