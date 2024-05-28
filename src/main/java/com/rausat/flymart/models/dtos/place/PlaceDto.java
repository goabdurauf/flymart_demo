package com.rausat.flymart.models.dtos.place;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class PlaceDto {
    @Size(min = 3)
    @NotNull
    private String name;
    private Long regionId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }
}
