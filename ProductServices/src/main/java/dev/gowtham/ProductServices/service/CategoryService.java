package dev.gowtham.ProductServices.service;

import dev.gowtham.ProductServices.dto.CategoryRequestDTO;
import dev.gowtham.ProductServices.dto.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryResponseDTO> getCategories();
    CategoryResponseDTO findCategoryByID(String id);
    CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO);
    CategoryResponseDTO findCategoryByName(String categoryName);
    CategoryResponseDTO updateCategory(String categoryID, CategoryRequestDTO categoryRequestDTO);
    Boolean deleteCategory(String categoryID);
}
