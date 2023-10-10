package com.example.buildingapi.client.fakestoreclient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;
}
