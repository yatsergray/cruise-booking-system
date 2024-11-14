package com.cruiseline.cruiseline.dto.mapper.realization;

import com.cruiseline.cruiseline.dto.CabinDTO;
import com.cruiseline.cruiseline.entity.Cabin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CabinDTOMapper {

    @Autowired
    private CabinClassDTOMapper cabinClassDTOMapper;

    public CabinDTO mapToDTO(Cabin entity) {
        return CabinDTO.builder()
                .id(entity.getId())
                .deckNumber(entity.getDeckNumber())
                .capacity(entity.getCapacity())
                .adultDailyCost(entity.getAdultDailyCost())
                .childDailyCost(entity.getChildDailyCost())
                .amountOnCruiseLiner(entity.getAmountOnCruiseLiner())
                .cabinClassDTO(cabinClassDTOMapper.mapToDTO(entity.getCabinClass()))
                .build();
    }

    public Cabin mapToEntity(CabinDTO dto) {
        return Cabin.builder()
                .id(dto.getId())
                .deckNumber(dto.getDeckNumber())
                .capacity(dto.getCapacity())
                .adultDailyCost(dto.getAdultDailyCost())
                .childDailyCost(dto.getChildDailyCost())
                .amountOnCruiseLiner(dto.getAmountOnCruiseLiner())
                .cabinClass(cabinClassDTOMapper.mapToEntity(dto.getCabinClassDTO()))
                .build();
    }

    public List<CabinDTO> mapToDTOList(List<Cabin> entities) {
        return entities.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<Cabin> mapToEntities(List<CabinDTO> dtoList) {
        return dtoList.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
    }
}
