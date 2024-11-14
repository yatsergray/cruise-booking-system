package com.cruiseline.cruiseline.service;

import com.cruiseline.cruiseline.entity.CruiseLiner;
import com.cruiseline.cruiseline.exception.NoSuchCruiseLinerExistsException;

import java.util.List;

public interface CruiseLinerService {
    CruiseLiner addCruiseLiner(CruiseLiner cruiseLiner);

    CruiseLiner copyAndUpdateCruiseLinerById(Long cruiseLinerId, CruiseLiner cruiseLiner) throws NoSuchCruiseLinerExistsException;

    void removeCruiseLinerById(Long id);

    void removeCruiseLiner(CruiseLiner cruiseLiner);

    CruiseLiner getCruiseLinerById(Long id) throws NoSuchCruiseLinerExistsException;

    List<CruiseLiner> getAllCruiseLiners();
}
