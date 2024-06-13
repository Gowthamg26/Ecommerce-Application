package dev.gowtham.ProductServices.mapper;

import dev.gowtham.ProductServices.dto.CategoryRequestDTO;
import dev.gowtham.ProductServices.dto.CategoryResponseDTO;
import dev.gowtham.ProductServices.dto.ProductResponseDTO;
import dev.gowtham.ProductServices.entity.ProductCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class CategoryMapper {

    public static CategoryResponseDTO EntityToDTOMapper(ProductCategory category){

        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        categoryResponseDTO.setCategoryName(category.getName());
        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();
        if (category.getProducts() != null){
            productResponseDTOS = category.getProducts().stream().
                    map(ProductMapper::entityToDtoMapper).collect(Collectors.toList());
        }
        categoryResponseDTO.setProducts(productResponseDTOS);
        return categoryResponseDTO;
    }

    public static ProductCategory dtoToEntityMapper(CategoryRequestDTO categoryRequestDTO){
        ProductCategory category = new ProductCategory();
        category.setName(categoryRequestDTO.getCategoryName());

        return category;
    }
}
