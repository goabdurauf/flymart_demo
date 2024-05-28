package com.rausat.flymart.services;

import com.rausat.flymart.mappers.UsersMapper;
import com.rausat.flymart.models.dtos.user.UserDto;
import com.rausat.flymart.models.dtos.user.UserResponseDto;
import com.rausat.flymart.models.entities.Role;
import com.rausat.flymart.models.entities.Users;
import com.rausat.flymart.repositories.RoleRepository;
import com.rausat.flymart.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UsersMapper usersMapper;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, UsersMapper usersMapper, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.usersMapper = usersMapper;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<UserResponseDto> getAll() {
        return userRepository.findAll().stream()
                .map(usersMapper::toUserResponseDto)
                .toList();
    }

    @Override
    public UserResponseDto create(UserDto userDto) {
        List<Role> allById = roleRepository.findAllById(userDto.getRoles());
        Users user = usersMapper.toUser(userDto);
        user.setRoles(new HashSet<>(allById));
        return usersMapper.toUserResponseDto(userRepository.save(user));
    }

    @Override
    public UserResponseDto update(Long id, UserDto userDto) {
        List<Role> allById = roleRepository.findAllById(userDto.getRoles());
        Users user = getUser(id);
        usersMapper.updatePlaceFroDTO(userDto, user);
        user.setRoles(new HashSet<>(allById));
        return usersMapper.toUserResponseDto(userRepository.save(user));
    }




    @Override
    public void delete(Long id) {
        Users user = getUser(id);
        userRepository.delete(user);
    }

    private Users getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity User not found with the given id: " + id));
    }
}
