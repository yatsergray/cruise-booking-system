package com.cruiseline.cruiseline.service;

import com.cruiseline.cruiseline.entity.Cabin;
import com.cruiseline.cruiseline.exception.NoSuchCabinExistsException;

import java.math.BigDecimal;
import java.util.List;

public interface CabinService {
    void addCabin(Cabin cabin);

    void updateCabinById(Long id, Long cruiseLinerId, Long cabinClassId, Long deckNumber, Long capacity, BigDecimal adultDailyCost, BigDecimal childDailyCost);

    void removeCabinById(Long id);

    void  removeCabin(Cabin cabin);

    Cabin getCabinById(Long id) throws NoSuchCabinExistsException;

    List<Cabin> getAllCabins();
}
