package com.cruiseline.cruiseline.dto.mapper;

import java.util.List;

public interface DTOMapper<T, R> {
    R mapToDTO(T entity);

    T mapToEntity(R dto);

    List<R> mapToDTOs(List<T> entities);

    List<T> mapToEntities(List<R> dtoSet);
}
