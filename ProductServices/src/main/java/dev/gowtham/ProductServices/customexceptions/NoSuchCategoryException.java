package dev.gowtham.ProductServices.customexceptions;

public class NoSuchCategoryException extends RuntimeException{

    public NoSuchCategoryException() {
        super();
    }

    public NoSuchCategoryException(String message) {
        super(message);
    }
}
