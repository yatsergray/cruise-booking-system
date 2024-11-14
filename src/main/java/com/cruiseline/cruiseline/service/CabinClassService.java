package com.cruiseline.cruiseline.service;

import com.cruiseline.cruiseline.entity.CabinClass;
import com.cruiseline.cruiseline.exception.NoSuchCabinClassExistsException;

import java.util.List;

public interface CabinClassService {
    CabinClass addCabinClass(CabinClass cabinClass);

    CabinClass copyAndUpdateCabinClassById(Long cabinClassId, CabinClass cabinClass) throws NoSuchCabinClassExistsException;

    void removeCabinClassById(Long id);

    void removeCabinClass(CabinClass cabinClass);

    CabinClass getCabinClassById(Long id) throws NoSuchCabinClassExistsException;

    List<CabinClass> getAllCabinClasses();
}
