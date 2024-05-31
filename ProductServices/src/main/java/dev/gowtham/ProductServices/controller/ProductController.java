package dev.gowtham.ProductServices.controller;

import dev.gowtham.ProductServices.controlleradvice.InvalidProductDetailException;
import dev.gowtham.ProductServices.dto.FakeStoreProductResponseDTO;
import dev.gowtham.ProductServices.dto.ProductRequestDTO;
import dev.gowtham.ProductServices.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity getAllProducts() {
        List<FakeStoreProductResponseDTO> productResponse = productService.getAllProducts();
        return ResponseEntity.ok(productResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable("id") int id){
        FakeStoreProductResponseDTO productResponseDTO = productService.getProductByID(id);
        return ResponseEntity.ok(productResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletedProductById(@PathVariable("id") int id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @PostMapping
    public ResponseEntity CreateProduct(@RequestBody ProductRequestDTO productRequestDTO){

        String title = productRequestDTO.getTitle();
        if (title.isBlank() || title.isEmpty() || title == null){
            throw new InvalidProductDetailException("Invalid product detail");
        }
        return ResponseEntity.ok(productService.createProduct(productRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity CreateProduct(@RequestBody ProductRequestDTO productRequestDTO, @PathVariable("id") int id){
        return ResponseEntity.ok(productService.updateProduct(productRequestDTO, id));
    }

}