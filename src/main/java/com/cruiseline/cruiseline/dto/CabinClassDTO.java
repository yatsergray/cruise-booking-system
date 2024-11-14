package com.cruiseline.cruiseline.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CabinClassDTO {
    private Long id;
    private String name;
    private List<CruiseLinerDTO> cruiseLinerDTOList;
}
