package com.cruiseline.cruiseline.service.impl;

import com.cruiseline.cruiseline.dao.CruiseLinerDAO;
import com.cruiseline.cruiseline.entity.Cabin;
import com.cruiseline.cruiseline.entity.CruiseLiner;
import com.cruiseline.cruiseline.exception.NoSuchCruiseLinerExistsException;
import com.cruiseline.cruiseline.service.CruiseLinerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class CruiseLinerServiceImpl implements CruiseLinerService {

    @Autowired
    private CruiseLinerDAO cruiseLinerDAO;

    @Override
    public CruiseLiner addCruiseLiner(CruiseLiner cruiseLiner) {
        Long cabinsAmount = 0L;
        Long passengersAmount = 0L;
        for (Cabin cabin : cruiseLiner.getCabins()) {
            cabin.setCruiseLiner(cruiseLiner);
            cabinsAmount += cabin.getAmountOnCruiseLiner();
            passengersAmount += cabin.getCapacity() * cabinsAmount;
        }
        cruiseLiner.setCabinsAmount(cabinsAmount);
        cruiseLiner.setPassengersAmount(passengersAmount);
        cruiseLiner.setCabinsAmount(cabinsAmount);
        return cruiseLinerDAO.save(cruiseLiner);
    }

    @Override
    public CruiseLiner copyAndUpdateCruiseLinerById(Long cruiseLinerId, CruiseLiner cruiseLiner) throws NoSuchCruiseLinerExistsException {
        CruiseLiner updatedCruiseLiner = getCruiseLinerById(cruiseLinerId);
        updatedCruiseLiner.setName(cruiseLiner.getName());
        updatedCruiseLiner.setCreationYear(cruiseLiner.getCreationYear());
        updatedCruiseLiner.setLength(cruiseLiner.getLength());
        updatedCruiseLiner.setWidth(cruiseLiner.getWidth());
        updatedCruiseLiner.setCruisingSpeed(cruiseLiner.getCruisingSpeed());
        updatedCruiseLiner.setStaffAmount(cruiseLiner.getStaffAmount());
        updatedCruiseLiner.setDecksAmount(cruiseLiner.getDecksAmount());
        updatedCruiseLiner.getCabins().clear();
        updatedCruiseLiner.getCabins().addAll(cruiseLiner.getCabins());
        Long updatedCabinsAmount = 0L;
        Long updatedPassengersAmount = 0L;
        for (Cabin cabin : cruiseLiner.getCabins()) {
            cabin.setCruiseLiner(updatedCruiseLiner);
            updatedCabinsAmount += cabin.getAmountOnCruiseLiner();
            updatedPassengersAmount += cabin.getCapacity() * updatedCabinsAmount;
        }
        updatedCruiseLiner.setCabinsAmount(updatedCabinsAmount);
        updatedCruiseLiner.setPassengersAmount(updatedPassengersAmount);
        return addCruiseLiner(updatedCruiseLiner);
    }

    @Override
    public void removeCruiseLinerById(Long id) {
        cruiseLinerDAO.deleteById(id);
    }

    @Override
    public void removeCruiseLiner(CruiseLiner cruiseLiner) {
        cruiseLinerDAO.delete(cruiseLiner);
    }

    @Override
    public CruiseLiner getCruiseLinerById(Long id) throws NoSuchCruiseLinerExistsException {
        return Optional.of(cruiseLinerDAO.getById(id)).orElseThrow(() -> new NoSuchCruiseLinerExistsException("Cruise liner with id " + id + " doesn't exist."));
    }

    @Override
    public List<CruiseLiner> getAllCruiseLiners() {
        return cruiseLinerDAO.findAll();
    }
}
