package com.rausat.flymart.models.dtos.request;

import com.rausat.flymart.models.dtos.place.PlaceDto;
import com.rausat.flymart.models.dtos.place.PlaceResponseDto;
import com.rausat.flymart.models.dtos.products.ProductResponseDto;

public class RequestResponseDto {
    private PlaceResponseDto place;
    private ProductResponseDto product;

    public PlaceResponseDto getPlace() {
        return place;
    }

    public void setPlace(PlaceResponseDto place) {
        this.place = place;
    }

    public ProductResponseDto getProduct() {
        return product;
    }

    public void setProduct(ProductResponseDto product) {
        this.product = product;
    }
}
