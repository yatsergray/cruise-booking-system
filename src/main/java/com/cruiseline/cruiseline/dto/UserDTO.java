package com.cruiseline.cruiseline.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private RoleDTO roleDTO;
    private List<CruiseDTO> cruiseDTOList = new ArrayList<>();
}
