package com.cruiseline.cruiseline.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CruiseLinerDTO {
    private Long id;
    private String name;
    private String creationYear;
    private BigDecimal length;
    private BigDecimal width;
    private BigDecimal cruisingSpeed;
    private Long staffAmount;
    private Long passengersAmount;
    private Long decksAmount;
    private Long cabinsAmount;
    private List<CabinDTO> cabinDTOList = new ArrayList<>();
}
