package com.example.buildingapi.Inheritance.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JTUserRepository extends JpaRepository<User, Long> {
    User save(User user);

    User findUserById(Long id);
}
