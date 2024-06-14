package dev.gowtham.ProductServices.controlleradvice;

import dev.gowtham.ProductServices.controller.CategoryController;
import dev.gowtham.ProductServices.customexceptions.InvalidProductDetailException;
import dev.gowtham.ProductServices.customexceptions.NoSuchCategoryException;
import dev.gowtham.ProductServices.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice(basePackageClasses = CategoryController.class)
public class CategoryExceptionHandler {

    @ExceptionHandler(InvalidProductDetailException.class)
    public ResponseEntity<ExceptionResponseDTO> invalidProductDetails(InvalidProductDetailException ipe){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(ipe.getMessage(), 400);

        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoSuchCategoryException.class)
    public ResponseEntity<ExceptionResponseDTO> noCategoryException(NoSuchCategoryException pe){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(pe.getMessage(), 404);

        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }
}