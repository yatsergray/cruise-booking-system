package com.cruiseline.cruiseline.service.impl;

import com.cruiseline.cruiseline.dao.CabinDAO;
import com.cruiseline.cruiseline.entity.Cabin;
import com.cruiseline.cruiseline.exception.NoSuchCabinExistsException;
import com.cruiseline.cruiseline.service.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CabinServiceImpl implements CabinService {

    @Autowired
    private CabinDAO cabinDAO;

    @Override
    public void addCabin(Cabin cabin) {
        cabinDAO.save(cabin);
    }

    @Override
    public void updateCabinById(Long id, Long cruiseLinerId, Long cabinClassId, Long deckNumber, Long capacity, BigDecimal adultDailyCost, BigDecimal childDailyCost) {
        cabinDAO.updateCabinById(id, cruiseLinerId, cabinClassId, deckNumber, capacity, adultDailyCost, childDailyCost);
    }

    @Override
    public void removeCabinById(Long id) {
        cabinDAO.deleteById(id);
    }

    @Override
    public void removeCabin(Cabin cabin) {
        cabinDAO.delete(cabin);
    }

    @Override
    public Cabin getCabinById(Long id) throws NoSuchCabinExistsException {
        return Optional.of(cabinDAO.getById(id)).orElseThrow(() -> new NoSuchCabinExistsException("Cabin with id " + id + " doesn't exist."));
    }

    @Override
    public List<Cabin> getAllCabins() {
        return cabinDAO.findAll();
    }
}
