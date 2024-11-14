package com.cruiseline.cruiseline.dto.mapper.realization;

import com.cruiseline.cruiseline.dto.CruiseLinerDTO;
import com.cruiseline.cruiseline.entity.CruiseLiner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CruiseLinerDTOMapper {

    @Autowired
    private CabinDTOMapper cabinDTOMapper;

    public CruiseLinerDTO mapToDTO(CruiseLiner entity) {
        return CruiseLinerDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .creationYear(entity.getCreationYear())
                .length(entity.getLength())
                .width(entity.getWidth())
                .cruisingSpeed(entity.getCruisingSpeed())
                .staffAmount(entity.getStaffAmount())
                .passengersAmount(entity.getPassengersAmount())
                .decksAmount(entity.getDecksAmount())
                .cabinsAmount(entity.getCabinsAmount())
                .cabinDTOList(cabinDTOMapper.mapToDTOList(entity.getCabins()))
                .build();
    }

    public CruiseLiner mapToEntity(CruiseLinerDTO dto) {
        return CruiseLiner.builder()
                .id(dto.getId())
                .name(dto.getName())
                .creationYear(dto.getCreationYear())
                .length(dto.getLength())
                .width(dto.getWidth())
                .cruisingSpeed(dto.getCruisingSpeed())
                .staffAmount(dto.getStaffAmount())
                .passengersAmount(dto.getPassengersAmount())
                .decksAmount(dto.getDecksAmount())
                .cabinsAmount(dto.getCabinsAmount())
                .cabins(cabinDTOMapper.mapToEntities(dto.getCabinDTOList()))
                .build();
    }

    public List<CruiseLinerDTO> mapToDTOList(List<CruiseLiner> entities) {
        return entities.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<CruiseLiner> mapToEntities(List<CruiseLinerDTO> dtoList) {
        return dtoList.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
    }
}
