package dev.gowtham.ProductServices.client;

import dev.gowtham.ProductServices.dto.FakeStoreProductResponseDTO;
import dev.gowtham.ProductServices.dto.LoveQuoteDTO;
import dev.gowtham.ProductServices.dto.ProductRequestDTO;
import dev.gowtham.ProductServices.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClient {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Value("${fakestore.api.base.url}")
    private String fakeStoreBaseAPIURL;

    @Value("${fakestore.api.product.path}")
    private String fakeStoreProductPath;

    public List<FakeStoreProductResponseDTO> getAllProducts(){
        String fakeStoreGetAllResponseURL = fakeStoreBaseAPIURL + fakeStoreProductPath;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponse = restTemplate.getForEntity(fakeStoreGetAllResponseURL, FakeStoreProductResponseDTO[].class);
        return List.of(productResponse.getBody());
    }

    public FakeStoreProductResponseDTO getProductById(int id){
        String fakeStoreGetProductById = fakeStoreBaseAPIURL + fakeStoreProductPath + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse = restTemplate.getForEntity(fakeStoreGetProductById, FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }

    public void deleteProductById(int id){
        String fakeStoreDeleteProductURL = fakeStoreBaseAPIURL + fakeStoreProductPath + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(fakeStoreDeleteProductURL);
    }

    public FakeStoreProductResponseDTO createProduct(ProductRequestDTO productRequestDTO){
        String fakeStoreProductPost = fakeStoreBaseAPIURL + fakeStoreProductPath;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse = restTemplate.postForEntity(fakeStoreProductPost, productRequestDTO, FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }

    public void updateProduct(ProductRequestDTO productRequestDTO, int id){
        String fakeStoreUpdateProductById = fakeStoreBaseAPIURL + fakeStoreProductPath + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.put(fakeStoreUpdateProductById, productRequestDTO);
    }
    
}
