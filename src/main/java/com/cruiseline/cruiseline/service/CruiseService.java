package com.cruiseline.cruiseline.service;

import com.cruiseline.cruiseline.entity.Cruise;
import com.cruiseline.cruiseline.exception.NoSuchCruiseExistsException;

import java.util.List;

public interface CruiseService {
    Cruise addCruise(Cruise cruise);

    Cruise copyAndUpdateCruiseById(Long cruiseId, Cruise cruise) throws NoSuchCruiseExistsException;

    void removeCruiseById(Long id);

    void removeCruise(Cruise cruise);

    Cruise getCruiseById(Long id) throws NoSuchCruiseExistsException;

    List<Cruise> getAllCruises();
}
