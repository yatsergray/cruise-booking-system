package com.cruiseline.cruiseline.dto.mapper.realization;

import com.cruiseline.cruiseline.dto.RoleDTO;
import com.cruiseline.cruiseline.entity.Role;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleDTOMapper {

    public RoleDTO mapToDTO(Role entity) {
        return RoleDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public Role mapToEntity(RoleDTO dto) {
        return Role.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }

    public List<RoleDTO> mapToDTOList(List<Role> entities) {
        return entities.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<Role> mapToEntities(List<RoleDTO> dtoList) {
        return dtoList.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
    }
}
