package com.example.buildingapi.Inheritance.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JTInstructorRepository extends JpaRepository<Instructor, Long> {

    Instructor save(Instructor instructor);

    Instructor findInstructorById(Long id);
}
