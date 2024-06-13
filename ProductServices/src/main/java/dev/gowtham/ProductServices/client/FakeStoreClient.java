package dev.gowtham.ProductServices.client;

import dev.gowtham.ProductServices.dto.ProductRequestDTO;
import dev.gowtham.ProductServices.dto.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
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

    public List<ProductResponseDTO> getAllProducts(){
        String fakeStoreGetAllResponseURL = fakeStoreBaseAPIURL + fakeStoreProductPath;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO[]> productResponse = restTemplate.getForEntity(fakeStoreGetAllResponseURL, ProductResponseDTO[].class);
        return List.of(productResponse.getBody());
    }

    public ProductResponseDTO getProductById(int id){
        String fakeStoreGetProductById = fakeStoreBaseAPIURL + fakeStoreProductPath + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> productResponse = restTemplate.getForEntity(fakeStoreGetProductById, ProductResponseDTO.class);
        return productResponse.getBody();
    }

    public void deleteProductById(int id){
        String fakeStoreDeleteProductURL = fakeStoreBaseAPIURL + fakeStoreProductPath + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(fakeStoreDeleteProductURL);
    }

    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO){
        String fakeStoreProductPost = fakeStoreBaseAPIURL + fakeStoreProductPath;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> productResponse = restTemplate.postForEntity(fakeStoreProductPost, productRequestDTO, ProductResponseDTO.class);
        return productResponse.getBody();
    }

    public ProductResponseDTO updateProduct(ProductRequestDTO productRequestDTO, int id){
        String fakeStoreUpdateProductById = fakeStoreBaseAPIURL + fakeStoreProductPath + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();

        HttpEntity<ProductRequestDTO> request = new HttpEntity<ProductRequestDTO>(productRequestDTO);

        ResponseEntity<ProductResponseDTO> fakestoreResponseObject = restTemplate.exchange(fakeStoreUpdateProductById,
                HttpMethod.PUT,
                request,
                ProductResponseDTO.class);

        return fakestoreResponseObject.getBody();
    }

}
