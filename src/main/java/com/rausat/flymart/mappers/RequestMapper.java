package com.rausat.flymart.mappers;

import com.rausat.flymart.models.dtos.request.RequestDto;
import com.rausat.flymart.models.dtos.request.RequestResponseDto;
import com.rausat.flymart.models.entities.Request;
import org.mapstruct.Mapper;

import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, PlaceMapper.class})
public interface RequestMapper {
    RequestResponseDto toRequestResponseDto(Request request);
    Request toRequest(RequestDto requestDto);
    void updateRegionFroDTO(RequestDto requestDto, @MappingTarget Request request);
}
