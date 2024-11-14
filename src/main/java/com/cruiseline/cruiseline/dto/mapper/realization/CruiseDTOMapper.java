package com.cruiseline.cruiseline.dto.mapper.realization;

import com.cruiseline.cruiseline.dto.CruiseDTO;
import com.cruiseline.cruiseline.entity.Cruise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CruiseDTOMapper {

    @Autowired
    private DestinationDTOMapper destinationDTOMapper;

    @Autowired
    private CruiseLinerDTOMapper cruiseLinerDTOMapper;

    public CruiseDTO mapToDTO(Cruise entity) {
        return CruiseDTO.builder()
                .id(entity.getId())
                .duration(entity.getDuration())
                .departureDateTime(entity.getDepartureDateTime())
                .arrivalDateTime(entity.getArrivalDateTime())
                .cruiseLinerDTO(cruiseLinerDTOMapper.mapToDTO(entity.getCruiseLiner()))
                .destinationDTOList(destinationDTOMapper.mapToDTOList(entity.getDestinations()))
                .build();
    }

    public Cruise mapToEntity(CruiseDTO dto) {
        return Cruise.builder()
                .id(dto.getId())
                .duration(dto.getDuration())
                .departureDateTime(dto.getDepartureDateTime())
                .arrivalDateTime(dto.getArrivalDateTime())
                .cruiseLiner(cruiseLinerDTOMapper.mapToEntity(dto.getCruiseLinerDTO()))
                .destinations(destinationDTOMapper.mapToEntities(dto.getDestinationDTOList()))
                .build();
    }

    public List<CruiseDTO> mapToDTOList(List<Cruise> entities) {
        return entities.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<Cruise> mapToEntities(List<CruiseDTO> dtoList) {
        return dtoList.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
    }
}
