package com.example.buildingapi.Inheritance.tableperclass;

import com.example.buildingapi.Inheritance.singleclass.Instructor;
import com.example.buildingapi.Inheritance.singleclass.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TPCInstructorRepository extends JpaRepository<com.example.buildingapi.Inheritance.tableperclass.Instructor, Long> {

    com.example.buildingapi.Inheritance.tableperclass.Instructor save(com.example.buildingapi.Inheritance.tableperclass.Instructor instructor);

    Instructor findInstructorById(Long id);
}
