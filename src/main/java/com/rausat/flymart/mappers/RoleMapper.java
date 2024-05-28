package com.rausat.flymart.mappers;

import com.rausat.flymart.models.dtos.RoleDto;
import com.rausat.flymart.models.entities.Role;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RoleMapper {

    RoleDto toRoleDto(Role role);
    Role toRole(RoleDto roleDto);

    @Mapping(target = "id", source = "id")
    void updateRoleFromDTO(RoleDto roleDto, @MappingTarget Role role, Long id);
}
