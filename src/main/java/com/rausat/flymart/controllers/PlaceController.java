package com.rausat.flymart.controllers;

import com.rausat.flymart.models.dtos.place.PlaceDto;
import com.rausat.flymart.models.dtos.place.PlaceResponseDto;
import com.rausat.flymart.services.PlaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/places")
public class PlaceController {
    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    @PreAuthorize("hasRole('PLACE_READ')")
    public ResponseEntity<List<PlaceResponseDto>> getAll() {
        return ResponseEntity.ok(placeService.getAll());
    }

    @PostMapping
    @PreAuthorize("hasRole('PLACE_CREATE')")
    public ResponseEntity<PlaceResponseDto> create(@RequestBody PlaceDto placeDto) {
        return ResponseEntity.ok(placeService.create(placeDto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('PLACE_EDIT')")
    public ResponseEntity<PlaceResponseDto> update(
            @PathVariable Long id,
            @RequestBody PlaceDto placeDto) {
        return ResponseEntity.ok(placeService.update(id, placeDto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('PLACE_DELETE')")
    public void delete(
            @PathVariable Long id) {
        placeService.delete(id);
    }
}
