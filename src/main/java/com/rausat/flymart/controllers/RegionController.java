package com.rausat.flymart.controllers;

import com.rausat.flymart.models.dtos.RegionDto;
import com.rausat.flymart.services.RegionService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/regions")
public class RegionController {
    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }


    @GetMapping
    @PreAuthorize("hasRole('REGION_READ')")
    public ResponseEntity<List<RegionDto>> getAll() {
        return ResponseEntity.ok(regionService.getAll());
    }

    @PostMapping
    @PreAuthorize("hasRole('REGION_CREATE')")
    public ResponseEntity<RegionDto> create(@RequestBody RegionDto regionDto) {
        return ResponseEntity.ok(regionService.create(regionDto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('REGION_EDIT')")
    public ResponseEntity<RegionDto> update(
            @PathVariable Long id,
            @RequestBody RegionDto regionDto) {
        return ResponseEntity.ok(regionService.update(id, regionDto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('REGION_DELETE')")
    public void delete(
            @PathVariable Long id) {
        regionService.delete(id);
    }
}
