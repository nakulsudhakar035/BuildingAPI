package com.example.buildingapi.dtos;

import com.example.buildingapi.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CategoryDTO {

    private long id;
    private String name;
    private String description;
    private List<Product> products;
}
