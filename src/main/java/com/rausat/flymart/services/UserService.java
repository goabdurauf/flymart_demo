package com.rausat.flymart.services;

import com.rausat.flymart.models.dtos.RegionDto;
import com.rausat.flymart.models.dtos.user.UserDto;
import com.rausat.flymart.models.dtos.user.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAll();
    UserResponseDto create(UserDto userDto);
    UserResponseDto update(Long id, UserDto userDto);
    void delete(Long id);
}
