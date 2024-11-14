package com.cruiseline.cruiseline.dto.mapper.realization;

import com.cruiseline.cruiseline.dto.DestinationDTO;
import com.cruiseline.cruiseline.entity.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DestinationDTOMapper {

    @Autowired
    private CityDTOMapper cityDTOMapper;

    public DestinationDTO mapToDTO(Destination entity) {
        return DestinationDTO.builder()
                .id(entity.getId())
                .cityDTO(cityDTOMapper.mapToDTO(entity.getCity()))
                .arrivalDateTime(entity.getArrivalDateTime())
                .departureDateTime(entity.getDepartureDateTime())
                .build();
    }

    public Destination mapToEntity(DestinationDTO dto) {
        return Destination.builder()
                .id(dto.getId())
                .city(cityDTOMapper.mapToEntity(dto.getCityDTO()))
                .arrivalDateTime(dto.getArrivalDateTime())
                .departureDateTime(dto.getDepartureDateTime())
                .build();
    }

    public List<DestinationDTO> mapToDTOList(List<Destination> entities) {
        return entities.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<Destination> mapToEntities(List<DestinationDTO> dtoList) {
        return dtoList.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
    }
}
