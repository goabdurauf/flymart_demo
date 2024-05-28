package com.rausat.flymart.controllers;

import com.rausat.flymart.models.dtos.RoleDto;
import com.rausat.flymart.services.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    private final RoleService roleService;


    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<RoleDto>> getAll() {
        return ResponseEntity.ok(roleService.getAll());
    }

    @PostMapping
    public ResponseEntity<RoleDto> create(@RequestBody RoleDto roleDto) {
        return ResponseEntity.ok(roleService.create(roleDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDto> update(
            @PathVariable Long id,
            @RequestBody RoleDto roleDto) {
        return ResponseEntity.ok(roleService.update(id, roleDto));
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id) {
        roleService.delete(id);
    }
}
