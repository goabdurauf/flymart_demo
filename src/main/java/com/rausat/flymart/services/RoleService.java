package com.rausat.flymart.services;

import com.rausat.flymart.models.dtos.RoleDto;

import java.util.List;

public interface RoleService {
    List<RoleDto> getAll();
    RoleDto create(RoleDto role);
    RoleDto update(Long id, RoleDto role);
    void delete(Long id);
}
