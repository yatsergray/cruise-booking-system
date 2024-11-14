package com.cruiseline.cruiseline.dto.mapper.realization;

import com.cruiseline.cruiseline.dto.CityDTO;
import com.cruiseline.cruiseline.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CityDTOMapper {

    @Autowired
    private CountryDTOMapper countryDTOMapper;

    public CityDTO mapToDTO(City entity) {
        return CityDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .countryDTO(countryDTOMapper.mapToDTO(entity.getCountry()))
                .build();
    }

    public City mapToEntity(CityDTO dto) {
        return City.builder()
                .id(dto.getId())
                .name(dto.getName())
                .country(countryDTOMapper.mapToEntity(dto.getCountryDTO()))
                .build();
    }

    public List<CityDTO> mapToDTOList(List<City> entities) {
        return entities.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<City> mapToEntities(List<CityDTO> dtoList) {
        return dtoList.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
    }
}
