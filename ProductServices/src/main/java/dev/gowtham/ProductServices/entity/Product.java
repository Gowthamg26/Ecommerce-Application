package dev.gowtham.ProductServices.entity;

import dev.gowtham.ProductServices.dto.FakeStoreProductRatingResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    public int id;
    public String title;
    public double price;
    public String description;
    public String category;
    public String image;

}
