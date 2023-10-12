package com.example.buildingapi.Inheritance.mappedsuperclass;

import com.example.buildingapi.Inheritance.singleclass.TA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MSCTARepository extends JpaRepository<com.example.buildingapi.Inheritance.mappedsuperclass.TA, Long> {

    com.example.buildingapi.Inheritance.mappedsuperclass.TA save(com.example.buildingapi.Inheritance.mappedsuperclass.TA ta);

    TA findTaById(Long id);
}
