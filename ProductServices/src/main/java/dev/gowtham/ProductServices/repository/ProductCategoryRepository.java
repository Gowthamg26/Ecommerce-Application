package dev.gowtham.ProductServices.repository;

import dev.gowtham.ProductServices.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, UUID> {
    ProductCategory findProductCategoryByName(String name);
}
