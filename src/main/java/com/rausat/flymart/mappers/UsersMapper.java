package com.rausat.flymart.mappers;

import com.rausat.flymart.models.dtos.user.UserDto;
import com.rausat.flymart.models.dtos.user.UserResponseDto;
import com.rausat.flymart.models.entities.Role;
import com.rausat.flymart.models.entities.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UsersMapper {
    UserResponseDto toUserResponseDto(Users user);
    @Mapping(target = "roles", ignore = true)
    Users toUser(UserDto userDto);
    @Mapping(target = "roles", ignore = true)
    void updatePlaceFroDTO(UserDto userDto, @MappingTarget Users user);


    default Long map(Role role){
        return role.getId();
    }
}
