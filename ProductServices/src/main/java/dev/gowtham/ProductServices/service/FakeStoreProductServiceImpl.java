package dev.gowtham.ProductServices.service;

import dev.gowtham.ProductServices.client.FakeStoreClient;
import dev.gowtham.ProductServices.customexceptions.NoProductFoundException;
import dev.gowtham.ProductServices.dto.ProductRequestDTO;
import dev.gowtham.ProductServices.dto.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductServiceImpl{

    @Autowired
    private FakeStoreClient fakeStoreClient;

    public ProductResponseDTO getProductByID(int id) {
        ProductResponseDTO fakeStoreProductResponse = fakeStoreClient.getProductById(id);
        if (fakeStoreProductResponse == null){
            throw new NoProductFoundException("No Product Found with the Id: " + id);
        }
        return fakeStoreProductResponse;
    }

    public List<ProductResponseDTO> getAllProducts() {
        List<ProductResponseDTO> fakestoreResponse = fakeStoreClient.getAllProducts();
        if (fakestoreResponse == null){
            throw new NoProductFoundException("No Product Found");
        }
        return fakestoreResponse;
    }

    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        ProductResponseDTO productResponseDTO = fakeStoreClient.createProduct(productRequestDTO);
        return productResponseDTO;
    }

    public ProductResponseDTO updateProduct(ProductRequestDTO productRequestDTO, int id) {
        ProductResponseDTO productResponseDTO = fakeStoreClient.updateProduct(productRequestDTO, id);
        return productResponseDTO;
    }

    public Boolean deleteProduct(int id) {
        fakeStoreClient.deleteProductById(id);
        return true;
    }

}