package dev.gowtham.ProductServices.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class ProductCategory extends BaseModel{

    private String name;

    @OneToMany(mappedBy = "productCategory")
    @JsonManagedReference
    private List<Product> products;
}
