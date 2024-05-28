package com.rausat.flymart.models.dtos;


import jakarta.validation.constraints.Size;

public class RegionDto {
    @Size(min = 3)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
