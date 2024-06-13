package dev.gowtham.ProductServices.service;

import dev.gowtham.ProductServices.dto.ProductRequestDTO;
import dev.gowtham.ProductServices.dto.ProductResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductResponseDTO getProductByID(UUID id);
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
    ProductResponseDTO updateProduct(ProductRequestDTO productRequestDTO, UUID id);
    Boolean deleteProduct(UUID id);
}
