package dev.gowtham.ProductServices.service;

import dev.gowtham.ProductServices.customexceptions.NoSuchCategoryException;
import dev.gowtham.ProductServices.dto.CategoryRequestDTO;
import dev.gowtham.ProductServices.dto.CategoryResponseDTO;
import dev.gowtham.ProductServices.entity.ProductCategory;
import dev.gowtham.ProductServices.mapper.CategoryMapper;
import dev.gowtham.ProductServices.repository.ProductCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{

    private ProductCategoryRepository categoryRepository;

    public CategoryServiceImpl(ProductCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponseDTO updateCategory(String categoryID, CategoryRequestDTO categoryRequestDTO) {
        UUID id = UUID.fromString(categoryID);
        ProductCategory category = categoryRepository.findById(id).orElseThrow(
                () -> new NoSuchCategoryException("No Such Category found")
        );
        category.setName(categoryRequestDTO.getCategoryName());
        categoryRepository.save(category);

        return CategoryMapper.EntityToDTOMapper(category);
    }

    @Override
    public Boolean deleteCategory(String categoryID) {
        UUID uuid = UUID.fromString(categoryID);
        ProductCategory category =  categoryRepository.findById(uuid).get();
        categoryRepository.delete(category);
        return true;
    }

    @Override
    public List<CategoryResponseDTO> getCategories() {
        List<ProductCategory> categories = categoryRepository.findAll();
        return categories.stream().map(CategoryMapper::EntityToDTOMapper).collect(Collectors.toList());
    }

    @Override
    public CategoryResponseDTO findCategoryByName(String categoryName) {
        ProductCategory category = categoryRepository.findProductCategoryByName(categoryName);
        if(category == null){
            new NoSuchCategoryException("No Category in Name " + categoryName );
        }
        return CategoryMapper.EntityToDTOMapper(category);

    }

    @Override
    public CategoryResponseDTO findCategoryByID(String id) {
        UUID categoryID = UUID.fromString(id);
        ProductCategory category = categoryRepository.findById(categoryID).orElseThrow(
                () -> new NoSuchCategoryException("No Such Category found")
        );
        return CategoryMapper.EntityToDTOMapper(category);
    }

    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO) {
        ProductCategory category = CategoryMapper.dtoToEntityMapper(categoryRequestDTO);
        categoryRepository.save(category);
        return CategoryMapper.EntityToDTOMapper(category);
    }
}
