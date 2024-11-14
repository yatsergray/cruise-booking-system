package com.cruiseline.cruiseline.service;

import com.cruiseline.cruiseline.entity.Destination;
import com.cruiseline.cruiseline.exception.NoSuchDestinationExistsException;

import java.time.LocalDateTime;
import java.util.List;

public interface DestinationService {
    void addDestination(Destination destination);

    void updateDestinationById(Long id, Long cruiseId, Long cityId, LocalDateTime arrivalDateTime, LocalDateTime departureDateTime);

    void removeDestinationById(Long id);

    void removeDestination(Destination destination);

    Destination getDestinationById(Long id) throws NoSuchDestinationExistsException;

    List<Destination> getAllDestinations();
}
