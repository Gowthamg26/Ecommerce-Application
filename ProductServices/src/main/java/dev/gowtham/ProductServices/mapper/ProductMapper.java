package dev.gowtham.ProductServices.mapper;
import dev.gowtham.ProductServices.dto.ProductRequestDTO;
import dev.gowtham.ProductServices.dto.ProductResponseDTO;
import dev.gowtham.ProductServices.entity.Product;

public class ProductMapper {

    public static ProductResponseDTO entityToDtoMapper(Product product){

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setTitle(product.getTitle());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setCategoryName(product.getProductCategory().getName());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setImage(product.getImage());

        return productResponseDTO;
    }

    public static Product dTOtoEntityMapper(ProductRequestDTO productRequestDTO){

        Product product = new Product();
        product.setTitle(productRequestDTO.getTitle());
        product.setImage(productRequestDTO.getImage());
        product.setPrice(productRequestDTO.getPrice());
        product.setDescription(productRequestDTO.getDescription());

        return product;
    }
}