package com.example.buildingapi.Inheritance.tableperclass;

import com.example.buildingapi.Inheritance.singleclass.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TPCMentorRepository extends JpaRepository<com.example.buildingapi.Inheritance.tableperclass.Mentor, Long> {

    com.example.buildingapi.Inheritance.tableperclass.Mentor save(com.example.buildingapi.Inheritance.tableperclass.Mentor mentor);

    Mentor findMentorById(Long id);
}
