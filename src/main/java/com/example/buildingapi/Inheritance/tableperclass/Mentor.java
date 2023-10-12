package com.example.buildingapi.Inheritance.tableperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbc_mentor")
@PrimaryKeyJoinColumn(name = "user_id")
public class Mentor extends User {
    private int numberOfSessions;
    private int numberOfMentees;
}