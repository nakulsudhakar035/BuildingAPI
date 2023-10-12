package com.example.buildingapi.Inheritance.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TPCUserRepository extends JpaRepository<com.example.buildingapi.Inheritance.tableperclass.User, Long> {
    com.example.buildingapi.Inheritance.tableperclass.User save(com.example.buildingapi.Inheritance.tableperclass.User user);

    User findUserById(Long id);
}
