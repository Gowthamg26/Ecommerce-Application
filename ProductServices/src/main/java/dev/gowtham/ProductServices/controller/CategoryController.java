package dev.gowtham.ProductServices.controller;

import dev.gowtham.ProductServices.customexceptions.InvalidCategoryDetails;
import dev.gowtham.ProductServices.dto.CategoryRequestDTO;
import dev.gowtham.ProductServices.dto.CategoryResponseDTO;
import dev.gowtham.ProductServices.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getCategories(){
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<CategoryResponseDTO> getCategoryByName(@PathVariable("name") String categoryName){
        if(categoryName.isEmpty() || categoryName.isBlank() || categoryName == null){
            throw new InvalidCategoryDetails("Invalid Name");
        }
        return ResponseEntity.ok(categoryService.findCategoryByName(categoryName));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable("id") String id){
        if(id.isEmpty() || id.isBlank() || id == null){
            throw new InvalidCategoryDetails("Invalid Category id");
        }
        return ResponseEntity.ok(categoryService.findCategoryByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable("id") String id, @RequestBody CategoryRequestDTO categoryRequestDTO){
        if(id.isEmpty() || id.isBlank() || id == null){
            throw new InvalidCategoryDetails("Invalid Category id");
        }
        return ResponseEntity.ok(categoryService.updateCategory(id, categoryRequestDTO));
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO categoryRequestDTO){
        return ResponseEntity.ok(categoryService.createCategory(categoryRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("id") String id){
        return ResponseEntity.ok(categoryService.deleteCategory(id));
    }
}