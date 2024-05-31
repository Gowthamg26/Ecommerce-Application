package dev.gowtham.ProductServices.service;

import dev.gowtham.ProductServices.client.FakeStoreClient;
import dev.gowtham.ProductServices.controlleradvice.NoProductFoundException;
import dev.gowtham.ProductServices.dto.FakeStoreProductResponseDTO;
import dev.gowtham.ProductServices.dto.ProductRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService{

    @Autowired
    private FakeStoreClient fakeStoreClient;


    @Override
    public FakeStoreProductResponseDTO getProductByID(int id) {

        FakeStoreProductResponseDTO fakeStoreProductResponse = fakeStoreClient.getProductById(id);
        if (fakeStoreProductResponse == null){
            throw new NoProductFoundException("No Product Found with the Id: " + id);
        }
        return fakeStoreProductResponse;
    }

    @Override
    public List<FakeStoreProductResponseDTO> getAllProducts() {
        List<FakeStoreProductResponseDTO> fakestoreResponse = fakeStoreClient.getAllProducts();
        if (fakestoreResponse == null){
            throw new NoProductFoundException("No Product Found");
        }
        return fakestoreResponse;
    }

    @Override
    public FakeStoreProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {

        FakeStoreProductResponseDTO productResponseDTO = fakeStoreClient.createProduct(productRequestDTO);

        return productResponseDTO;
    }

    @Override
    public String updateProduct(ProductRequestDTO productRequestDTO, int id) {
        fakeStoreClient.updateProduct(productRequestDTO, id);
        return "updated";
    }

    @Override
    public Boolean deleteProduct(int id) {
        fakeStoreClient.deleteProductById(id);
        return true;
    }

}