package dev.gowtham.ProductServices.controlleradvice;

import dev.gowtham.ProductServices.controller.ProductController;
import dev.gowtham.ProductServices.dto.ExceptionResponseDTO;
import dev.gowtham.ProductServices.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = ProductController.class)
public class ProductControllerExceptionHandler {

    @ExceptionHandler(NoProductFoundException.class)
    public ResponseEntity productNotFound(NoProductFoundException pe){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(pe.getMessage(), 404);

        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidProductDetailException.class)
    public ResponseEntity invalidProductDetails(InvalidProductDetailException ipe){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(ipe.getMessage(), 400);

        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.BAD_REQUEST);
    }
}