package dev.gowtham.ProductServices.customexceptions;

public class InvalidCategoryDetails extends RuntimeException{

    public InvalidCategoryDetails() {
        super();
    }

    public InvalidCategoryDetails(String message) {
        super(message);
    }
}
