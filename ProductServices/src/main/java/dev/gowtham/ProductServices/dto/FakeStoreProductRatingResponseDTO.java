package dev.gowtham.ProductServices.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductRatingResponseDTO {
    private double rate;
    private int count;
}