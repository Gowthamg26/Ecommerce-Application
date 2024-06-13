package dev.gowtham.ProductServices.service;

import dev.gowtham.ProductServices.customexceptions.NoProductFoundException;
import dev.gowtham.ProductServices.dto.ProductRequestDTO;
import dev.gowtham.ProductServices.dto.ProductResponseDTO;
import dev.gowtham.ProductServices.entity.Product;
import dev.gowtham.ProductServices.entity.ProductCategory;
import dev.gowtham.ProductServices.mapper.ProductMapper;
import dev.gowtham.ProductServices.repository.ProductCategoryRepository;
import dev.gowtham.ProductServices.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service("ProductServiceImpl")
public class ProductServiceImpl implements ProductService{

    public ProductRepository productRepository;
    public ProductCategoryRepository productCategoryRepository;
    public CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.categoryService = categoryService;
    }

    @Override
    public ProductResponseDTO getProductByID(UUID id) {
        Product getProduct = productRepository.findById(id).orElseThrow(
                () -> new NoProductFoundException("No Product found from this id")
        );
        return ProductMapper.entityToDtoMapper(getProduct);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();

        List<ProductResponseDTO> productResponseDTOS = products.stream().map(product -> ProductMapper.entityToDtoMapper(product))
                .collect(Collectors.toList());

        return productResponseDTOS;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO){

        Product product = ProductMapper.dTOtoEntityMapper(productRequestDTO);
        ProductCategory productCategory = productCategoryRepository.findProductCategoryByName(productRequestDTO.getCategoryName());
        product.setProductCategory(productCategory);
        productRepository.save(product);
        return ProductMapper.entityToDtoMapper(product);
    }

    @Override
    public ProductResponseDTO updateProduct(ProductRequestDTO productRequestDTO, UUID id) {

        Product product = productRepository.findById(id).orElseThrow(
                () -> new NoProductFoundException("No Product found from this id")
        );
        product.setTitle(productRequestDTO.getTitle());
        product.setImage(productRequestDTO.getImage());
        product.setPrice(productRequestDTO.getPrice());
        product.setDescription(productRequestDTO.getDescription());
        ProductCategory productCategory = productCategoryRepository.findProductCategoryByName(productRequestDTO.getCategoryName());
        product.setProductCategory(productCategory);
        productRepository.save(product);
        return ProductMapper.entityToDtoMapper(product);

    }

    @Override
    public Boolean deleteProduct(UUID id) {
        productRepository.deleteById(id);
        return true;
    }

}