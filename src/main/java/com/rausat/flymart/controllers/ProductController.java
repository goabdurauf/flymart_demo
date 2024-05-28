package com.rausat.flymart.controllers;

import com.rausat.flymart.models.dtos.products.ProductDto;
import com.rausat.flymart.models.dtos.products.ProductResponseDto;
import com.rausat.flymart.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @PreAuthorize("hasRole('PRODUCT_READ') or hasRole('OFFER_READ')")
    public ResponseEntity<List<ProductResponseDto>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('PRODUCT_READ') or hasRole('OFFER_READ')")
    public ResponseEntity<ProductResponseDto> getById(@Valid @PathVariable Long id){
        return ResponseEntity.ok(productService.getById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('PRODUCT_CREATE')")
    public ResponseEntity<ProductResponseDto> create(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.create(productDto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('PRODUCT_EDIT')")
    public ResponseEntity<ProductResponseDto> update(
            @PathVariable Long id,
            @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.update(id, productDto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('PRODUCT_DELETE')")
    public void delete(
            @PathVariable Long id) {
        productService.delete(id);
    }
}
