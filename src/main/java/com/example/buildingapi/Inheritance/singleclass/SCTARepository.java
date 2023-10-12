package com.example.buildingapi.Inheritance.singleclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SCTARepository extends JpaRepository<TA, Long> {

    TA save(TA ta);

    TA findTaById(Long id);
}
