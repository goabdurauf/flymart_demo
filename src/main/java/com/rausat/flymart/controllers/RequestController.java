package com.rausat.flymart.controllers;

import com.rausat.flymart.models.dtos.request.RequestDto;
import com.rausat.flymart.models.dtos.request.RequestResponseDto;
import com.rausat.flymart.services.RequestService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/requests")
@Validated
public class RequestController {
    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    @PreAuthorize("hasRole('REQUEST_READ')")
    public ResponseEntity<List<RequestResponseDto>> getAll() {
        return ResponseEntity.ok(requestService.getAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('REQUEST_READ')")
    public ResponseEntity<RequestResponseDto> getAll(@PathVariable Long id) {
        return ResponseEntity.ok(requestService.getById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('REQUEST_CREATE')")
    public ResponseEntity<RequestResponseDto> create(@NotNull @RequestBody @Valid RequestDto requestDto) {
        return ResponseEntity.ok(requestService.create(requestDto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('REQUEST_EDIT')")
    public ResponseEntity<RequestResponseDto> update(
            @NonNull @PathVariable Long id,
            @NotNull @RequestBody RequestDto requestDto) {
        return ResponseEntity.ok(requestService.update(id, requestDto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('REQUEST_DELETE')")
    public void delete(
            @NonNull @PathVariable Long id) {
        requestService.delete(id);
    }
}
