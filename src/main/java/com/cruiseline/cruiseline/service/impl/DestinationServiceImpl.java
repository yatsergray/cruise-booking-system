package com.cruiseline.cruiseline.service.impl;

import com.cruiseline.cruiseline.dao.DestinationDAO;
import com.cruiseline.cruiseline.entity.Destination;
import com.cruiseline.cruiseline.exception.NoSuchDestinationExistsException;
import com.cruiseline.cruiseline.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class DestinationServiceImpl implements DestinationService {

    @Autowired
    private DestinationDAO destinationDAO;

    @Override
    public void addDestination(Destination destination) {
        destinationDAO.save(destination);
    }

    @Override
    public void updateDestinationById(Long id, Long cruiseId, Long cityId, LocalDateTime arrivalDateTime, LocalDateTime departureDateTime) {
        destinationDAO.updateDestinationById(id, cruiseId, cityId, arrivalDateTime, departureDateTime);
    }

    @Override
    public void removeDestinationById(Long id) {
        destinationDAO.deleteById(id);
    }

    @Override
    public void removeDestination(Destination destination) {
        destinationDAO.delete(destination);
    }

    @Override
    public Destination getDestinationById(Long id) throws NoSuchDestinationExistsException {
        return Optional.of(destinationDAO.getById(id)).orElseThrow(() -> new NoSuchDestinationExistsException("Destination with id " + id + " doesn't exist."));
    }

    @Override
    public List<Destination> getAllDestinations() {
        return destinationDAO.findAll();
    }
}
