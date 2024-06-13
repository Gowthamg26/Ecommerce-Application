package dev.gowtham.ProductServices.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryResponseDTO {
    private String categoryName;
    private List<ProductResponseDTO> products;
}
