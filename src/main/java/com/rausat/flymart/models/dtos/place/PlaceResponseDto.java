package com.rausat.flymart.models.dtos.place;

import com.rausat.flymart.models.dtos.RegionDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PlaceResponseDto {
    @Size(min = 3)
    @NotNull
    private String name;
    private RegionDto region;

    public String getName() {
        return name;
    }

    public RegionDto getRegion() {
        return region;
    }

    public void setRegion(RegionDto region) {
        this.region = region;
    }

    public void setName(String name) {
        this.name = name;
    }


}
