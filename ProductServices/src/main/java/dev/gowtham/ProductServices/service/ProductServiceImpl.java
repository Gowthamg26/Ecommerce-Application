package dev.gowtham.ProductServices.service;

import dev.gowtham.ProductServices.dto.FakeStoreProductResponseDTO;
import dev.gowtham.ProductServices.dto.ProductRequestDTO;

import java.util.List;

public class ProductServiceImpl implements ProductService{

    @Override
    public FakeStoreProductResponseDTO getProductByID(int id) {
        return null;
    }

    @Override
    public List<FakeStoreProductResponseDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public FakeStoreProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        return null;
    }

    @Override
    public String updateProduct(ProductRequestDTO productRequestDTO, int id) {
        return "";
    }

    @Override
    public Boolean deleteProduct(int id) {
        return null;
    }
}
