package com.cruiseline.cruiseline.dto.mapper.realization;

import com.cruiseline.cruiseline.dto.CountryDTO;
import com.cruiseline.cruiseline.entity.Country;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryDTOMapper {

    public CountryDTO mapToDTO(Country entity) {
        return CountryDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public Country mapToEntity(CountryDTO dto) {
        return Country.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }

    public List<CountryDTO> mapToDTOList(List<Country> entities) {
        return entities.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<Country> mapToEntities(List<CountryDTO> dtoList) {
        return dtoList.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
    }
}
