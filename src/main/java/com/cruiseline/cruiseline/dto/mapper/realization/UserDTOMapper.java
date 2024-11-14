package com.cruiseline.cruiseline.dto.mapper.realization;

import com.cruiseline.cruiseline.dto.UserDTO;
import com.cruiseline.cruiseline.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDTOMapper {

    @Autowired
    private RoleDTOMapper roleDTOMapper;

    @Autowired
    private CruiseDTOMapper cruiseDTOMapper;

    public UserDTO mapToDTO(User entity) {
        return UserDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .roleDTO(roleDTOMapper.mapToDTO(entity.getRole()))
                .cruiseDTOList(cruiseDTOMapper.mapToDTOList(entity.getCruises()))
                .build();
    }

    public User mapToEntity(UserDTO dto) {
        return User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .role(roleDTOMapper.mapToEntity(dto.getRoleDTO()))
                .cruises(cruiseDTOMapper.mapToEntities(dto.getCruiseDTOList()))
                .build();
    }

    public List<UserDTO> mapToDTOList(List<User> entities) {
        return entities.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<User> mapToEntities(List<UserDTO> dtoList) {
        return dtoList.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
    }
}
