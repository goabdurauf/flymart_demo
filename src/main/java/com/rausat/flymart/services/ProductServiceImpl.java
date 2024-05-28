package com.rausat.flymart.services;

import com.rausat.flymart.mappers.ProductMapper;
import com.rausat.flymart.models.dtos.products.ProductDto;
import com.rausat.flymart.models.dtos.products.ProductResponseDto;
import com.rausat.flymart.models.entities.Product;
import com.rausat.flymart.models.entities.Users;
import com.rausat.flymart.repositories.ProductRepository;
import com.rausat.flymart.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final UserRepository userRepository;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, UserRepository userRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }


    @Override
    public List<ProductResponseDto> getAll() {
        return productRepository.findAll().stream()
                .map(productMapper::toProductresponseDto)
                .toList();
    }

    @Override
    public ProductResponseDto create(ProductDto productDto) {
        Users user = getUser(productDto.getUserId());
        Product product = productMapper.toProduct(productDto);
        product.setUser(user);
        return productMapper.toProductresponseDto(productRepository.save(product));
    }


    @Override
    public ProductResponseDto update(Long id, ProductDto productDto) {
        Users user = getUser(productDto.getUserId());
        Product product = getProduct(id);
        productMapper.updateProductFroDTO(productDto, product, user);
        return productMapper.toProductresponseDto(product);
    }

    @Override
    public void delete(Long id) {
        Product product = getProduct(id);
        productRepository.delete(product);
    }

    @Override
    public ProductResponseDto getById(Long id) {
        return productMapper.toProductresponseDto(getProduct(id));
    }

    private Users getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User entity not found with this id: " + userId));
    }

    private Product getProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new EntityNotFoundException("Product entity not found with this id: " + productId));
    }
}
