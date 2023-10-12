package com.example.buildingapi.Inheritance.tableperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbc_ta")
@PrimaryKeyJoinColumn(name = "user_id")
public class TA extends User {
    private double averageRating;
}
