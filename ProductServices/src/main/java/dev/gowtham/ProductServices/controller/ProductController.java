package dev.gowtham.ProductServices.controller;

import dev.gowtham.ProductServices.customexceptions.InvalidProductDetailException;
import dev.gowtham.ProductServices.dto.ProductRequestDTO;
import dev.gowtham.ProductServices.dto.ProductResponseDTO;
import dev.gowtham.ProductServices.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("ProductServiceImpl") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity getAllProducts() {
        List<ProductResponseDTO> productResponse = productService.getAllProducts();
        return ResponseEntity.ok(productResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable("id") UUID id){
        ProductResponseDTO productResponseDTO = productService.getProductByID(id);
        return ResponseEntity.ok(productResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletedProductById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody ProductRequestDTO productRequestDTO){

        String title = productRequestDTO.getTitle();
        if (title.isBlank() || title.isEmpty() || title == null){
            throw new InvalidProductDetailException("Invalid product detail");
        }
        return ResponseEntity.ok(productService.createProduct(productRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@RequestBody ProductRequestDTO productRequestDTO, @PathVariable("id") UUID id){
        return ResponseEntity.ok(productService.updateProduct(productRequestDTO, id));
    }

}