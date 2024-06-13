package dev.gowtham.ProductServices.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {

    private String title;

    private String description;

    private double price;

    private String categoryName;

    private String image;

}
