package com.example.buildingapi.Inheritance.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JTTARepository extends JpaRepository<TA, Long> {

    TA save(TA ta);

    TA findTaById(Long id);
}
