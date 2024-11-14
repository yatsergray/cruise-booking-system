package com.cruiseline.cruiseline.dto.mapper.realization;

import com.cruiseline.cruiseline.dto.CabinClassDTO;
import com.cruiseline.cruiseline.entity.CabinClass;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CabinClassDTOMapper {

    public CabinClassDTO mapToDTO(CabinClass entity) {
        return CabinClassDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public CabinClass mapToEntity(CabinClassDTO dto) {
        return CabinClass.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }

    public List<CabinClassDTO> mapToDTOList(List<CabinClass> entities) {
        return entities.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<CabinClass> mapToEntities(List<CabinClassDTO> dtoList) {
        return dtoList.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
    }
}
