package dev.gowtham.ProductServices.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {

    private String title;
    private double price;
    private String description;
    private String categoryName;
    private String image;

}