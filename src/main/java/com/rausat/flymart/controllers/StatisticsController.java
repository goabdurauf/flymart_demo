package com.rausat.flymart.controllers;

import com.rausat.flymart.models.dtos.RegionPerNTDto;
import com.rausat.flymart.services.StatisticSeriviceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/statistics")
public class StatisticsController {
    private final StatisticSeriviceImpl statisticSerivice;

    public StatisticsController(StatisticSeriviceImpl statisticSerivice) {
        this.statisticSerivice = statisticSerivice;
    }

    @GetMapping
    public ResponseEntity<List<RegionPerNTDto>> getDeliveryRegionsPerNT(){
        return ResponseEntity.ok(statisticSerivice.getRegionPerBTDto());
    }
}
