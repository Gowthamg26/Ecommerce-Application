package dev.gowtham.ProductServices.service;

import dev.gowtham.ProductServices.dto.FakeStoreProductRatingResponseDTO;
import dev.gowtham.ProductServices.dto.FakeStoreProductResponseDTO;
import dev.gowtham.ProductServices.dto.ProductRequestDTO;
import dev.gowtham.ProductServices.entity.Product;

import java.util.List;

public interface ProductService {
    FakeStoreProductResponseDTO getProductByID(int id);
    List<FakeStoreProductResponseDTO> getAllProducts();
    FakeStoreProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
    String updateProduct(ProductRequestDTO productRequestDTO, int id);
    Boolean deleteProduct(int id);
}
