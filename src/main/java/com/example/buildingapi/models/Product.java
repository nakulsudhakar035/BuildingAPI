package com.example.buildingapi.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {

    private String title;
    private double price;
    private String description;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;
    private String imageUrl;
}
