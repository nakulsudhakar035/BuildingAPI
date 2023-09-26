package com.example.buildingapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ProductDTO {
    private long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
