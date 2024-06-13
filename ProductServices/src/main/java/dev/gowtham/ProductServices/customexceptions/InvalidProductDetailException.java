package dev.gowtham.ProductServices.customexceptions;

public class InvalidProductDetailException extends RuntimeException{

    public InvalidProductDetailException() {
        super();
    }

    public InvalidProductDetailException(String message) {
        super(message);
    }
}
