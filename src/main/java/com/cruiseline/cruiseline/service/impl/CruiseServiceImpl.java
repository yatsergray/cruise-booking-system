package com.cruiseline.cruiseline.service.impl;

import com.cruiseline.cruiseline.dao.CruiseDAO;
import com.cruiseline.cruiseline.entity.Cruise;
import com.cruiseline.cruiseline.entity.Destination;
import com.cruiseline.cruiseline.exception.NoSuchCruiseExistsException;
import com.cruiseline.cruiseline.service.CruiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CruiseServiceImpl implements CruiseService {

    @Autowired
    private CruiseDAO cruiseDAO;

    @Override
    public Cruise addCruise(Cruise cruise) {
        List<Destination> destinations = cruise.getDestinations();
        destinations.forEach(destination -> destination.setCruise(cruise));
        LocalDateTime departureDateTime = destinations.get(0).getDepartureDateTime();
        LocalDateTime arrivalDateTime = destinations.get(destinations.size() - 1).getArrivalDateTime();
        cruise.setDepartureDateTime(departureDateTime);
        cruise.setArrivalDateTime(arrivalDateTime);
        cruise.setDuration(Duration.between(departureDateTime, arrivalDateTime).toDays());
        return cruiseDAO.save(cruise);
    }

    @Override
    public Cruise copyAndUpdateCruiseById(Long cruiseId, Cruise cruise) throws NoSuchCruiseExistsException {
        Cruise updatedCruise = getCruiseById(cruiseId);
        List<Destination> destinations = cruise.getDestinations();
        destinations.forEach(destination -> destination.setCruise(updatedCruise));
        LocalDateTime departureDateTime = destinations.get(0).getDepartureDateTime();
        LocalDateTime arrivalDateTime = destinations.get(destinations.size() - 1).getArrivalDateTime();
        updatedCruise.getDestinations().clear();
        updatedCruise.getDestinations().addAll(destinations);
        updatedCruise.setCruiseLiner(cruise.getCruiseLiner());
        updatedCruise.setArrivalDateTime(arrivalDateTime);
        updatedCruise.setDepartureDateTime(departureDateTime);
        updatedCruise.setDuration(Duration.between(departureDateTime, arrivalDateTime).toDays());
        return cruiseDAO.save(updatedCruise);
    }

    @Override
    public void removeCruiseById(Long id) {
        cruiseDAO.deleteById(id);
    }

    @Override
    public void removeCruise(Cruise cruise) {
        cruiseDAO.delete(cruise);
    }

    @Override
    public Cruise getCruiseById(Long id) throws NoSuchCruiseExistsException {
        return Optional.of(cruiseDAO.getById(id)).orElseThrow(() -> new NoSuchCruiseExistsException("Cruise with id " + id + " doesn't exist."));
    }

    @Override
    public List<Cruise> getAllCruises() {
        return cruiseDAO.findAll();
    }
}
