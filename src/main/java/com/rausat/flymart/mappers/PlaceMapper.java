package com.rausat.flymart.mappers;

import com.rausat.flymart.models.dtos.place.PlaceDto;
import com.rausat.flymart.models.dtos.place.PlaceResponseDto;
import com.rausat.flymart.models.entities.Place;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {RegionMapper.class})
public interface PlaceMapper {
    PlaceResponseDto toPlaceResponseDto(Place place);
    Place toPlace(PlaceDto placeDto);

    void updatePlaceFroDTO(PlaceDto placeDto, @MappingTarget Place place);
}
