package com.rausat.flymart.services;

import com.rausat.flymart.models.dtos.products.ProductDto;
import com.rausat.flymart.models.dtos.products.ProductResponseDto;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto> getAll();
    ProductResponseDto create(ProductDto productDto);
    ProductResponseDto update(Long id, ProductDto productDto);
    void delete(Long id);
    ProductResponseDto getById(Long id);
}
