package com.example.buildingapi.Inheritance.tableperclass;

import com.example.buildingapi.Inheritance.singleclass.Mentor;
import com.example.buildingapi.Inheritance.singleclass.TA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TPCTARepository extends JpaRepository<com.example.buildingapi.Inheritance.tableperclass.TA, Long> {

    com.example.buildingapi.Inheritance.tableperclass.TA save(com.example.buildingapi.Inheritance.tableperclass.TA ta);

    TA findTaById(Long id);
}
