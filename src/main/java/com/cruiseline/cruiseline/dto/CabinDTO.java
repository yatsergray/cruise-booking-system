package com.cruiseline.cruiseline.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CabinDTO {
    private Long id;
    private Long deckNumber;
    private Long capacity;
    private BigDecimal adultDailyCost;
    private BigDecimal childDailyCost;
    private CabinClassDTO cabinClassDTO;
    private Long amountOnCruiseLiner;
}