package com.rausat.flymart.services;

import com.rausat.flymart.mappers.RoleMapper;
import com.rausat.flymart.models.dtos.RoleDto;
import com.rausat.flymart.models.entities.Role;
import com.rausat.flymart.repositories.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService{
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository,RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleDto> getAll() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toRoleDto)
                .toList();
    }

    @Override
    public RoleDto create(RoleDto role) {
        roleRepository.save(roleMapper.toRole(role));
        return role;
    }

    @Override
    public RoleDto update(Long id, RoleDto role) {
        Role dbRole = findById(id);
        roleMapper.updateRoleFromDTO(role,dbRole,id);

        return roleMapper.toRoleDto(roleRepository.save(dbRole));
    }

    @Override
    public void delete(Long id) {
        Role byId = findById(id);
        roleRepository.delete(byId);
    }

    private Role findById(Long id){
        return roleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("entity not found with this id: " + id));
    }
}
