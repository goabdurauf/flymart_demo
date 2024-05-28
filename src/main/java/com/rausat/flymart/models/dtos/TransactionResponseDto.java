package com.rausat.flymart.models.dtos;

import com.rausat.flymart.models.dtos.products.ProductResponseDto;
import com.rausat.flymart.models.dtos.request.RequestResponseDto;
import com.rausat.flymart.models.dtos.user.UserResponseDto;

import java.time.LocalDate;

public class TransactionResponseDto {
    private Long id;
    private UserResponseDto users;
    private RequestResponseDto request;
    private ProductResponseDto product;
    private LocalDate createdDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserResponseDto getUsers() {
        return users;
    }

    public void setUsers(UserResponseDto users) {
        this.users = users;
    }

    public RequestResponseDto getRequest() {
        return request;
    }

    public void setRequest(RequestResponseDto request) {
        this.request = request;
    }

    public ProductResponseDto getProduct() {
        return product;
    }

    public void setProduct(ProductResponseDto product) {
        this.product = product;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
