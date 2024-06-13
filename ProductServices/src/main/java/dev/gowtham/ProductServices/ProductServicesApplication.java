package dev.gowtham.ProductServices;

import dev.gowtham.ProductServices.entity.ProductCategory;
import dev.gowtham.ProductServices.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProductServicesApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProductServicesApplication.class, args);

	}

}
