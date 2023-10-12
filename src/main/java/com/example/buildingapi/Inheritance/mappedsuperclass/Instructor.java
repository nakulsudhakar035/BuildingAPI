package com.example.buildingapi.Inheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_instructor")
public class Instructor extends User {
    private boolean isHandsome;
}
