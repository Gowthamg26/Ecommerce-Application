package dev.gowtham.ProductServices.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{

    public String title;
    public double price;
    public String description;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    public ProductCategory productCategory;
    public String image;

}
