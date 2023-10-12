package com.example.buildingapi.Inheritance.singleclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_mentor")
@DiscriminatorValue("3")
public class Mentor extends User {
    private int numberOfSessions;
    private int numberOfMentees;
}