package com.rausat.flymart.mappers;

import com.rausat.flymart.models.dtos.RegionDto;
import com.rausat.flymart.models.entities.Region;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RegionMapper {
    RegionDto toRegionDto(Region region);
    Region toRegion(RegionDto regionDto);

    @Mapping(target = "id", source = "id")
    void updateRegionFroDTO(RegionDto regionDto, @MappingTarget Region region, Long id);

}
