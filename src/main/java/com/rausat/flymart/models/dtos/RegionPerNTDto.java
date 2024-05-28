package com.rausat.flymart.models.dtos;

import java.util.List;

public class RegionPerNTDto {
    private Integer transactionNumber;
    private List<RegionDto> regions;

    public Integer getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(Integer transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public List<RegionDto> getRegions() {
        return regions;
    }

    public void setRegions(List<RegionDto> regions) {
        this.regions = regions;
    }
}
