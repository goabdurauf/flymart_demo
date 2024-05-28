package com.rausat.flymart.services;

import com.rausat.flymart.models.dtos.place.PlaceDto;
import com.rausat.flymart.models.dtos.place.PlaceResponseDto;

import java.util.List;

public interface PlaceService {
    List<PlaceResponseDto> getAll();
    PlaceResponseDto create(PlaceDto placeDto);
    PlaceResponseDto update(Long id, PlaceDto placeDto);
    void delete(Long id);
}
