package com.rausat.flymart.services;

import com.rausat.flymart.models.dtos.RegionDto;

import java.util.List;

public interface RegionService {
    List<RegionDto> getAll();
    RegionDto create(RegionDto regionDto);
    RegionDto update(Long id, RegionDto regionDto);
    void delete(Long id);

}
