package dev.gowtham.ProductServices.controlleradvice;

public class InvalidProductDetailException extends RuntimeException{

    public InvalidProductDetailException() {
        super();
    }

    public InvalidProductDetailException(String message) {
        super(message);
    }
}
