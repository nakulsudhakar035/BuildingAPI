package com.example.buildingapi.client.fakestoreclient;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;
}
