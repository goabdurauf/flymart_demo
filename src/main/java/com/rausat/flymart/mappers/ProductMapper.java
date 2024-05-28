package com.rausat.flymart.mappers;


import com.rausat.flymart.models.dtos.products.ProductDto;
import com.rausat.flymart.models.dtos.products.ProductResponseDto;
import com.rausat.flymart.models.entities.Product;
import com.rausat.flymart.models.entities.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring",uses = {UsersMapper.class})
public interface ProductMapper {
//    @Mapping(target = "regionId", source = "region.id")
    ProductResponseDto toProductresponseDto(Product product);

    Product toProduct(ProductDto productDto);
    @Mapping(target = "image", source = "productDto.image")
    @Mapping(target = "status", source = "productDto.status")
    void updateProductFroDTO(ProductDto productDto, @MappingTarget Product product, Users user);
}
