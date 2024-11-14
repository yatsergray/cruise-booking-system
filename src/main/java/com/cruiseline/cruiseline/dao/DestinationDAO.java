package com.cruiseline.cruiseline.dao;

import com.cruiseline.cruiseline.entity.Cruise;
import com.cruiseline.cruiseline.entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface DestinationDAO extends JpaRepository<Destination, Long> {

    @Modifying
    @Query(value = "UPDATE destinations destination SET destination.cruise_id = :cruise_id, destination.city_id = :city_id, destination.arrival_date_time = :arrival_date_time, destination.departure_date_time = :departure_date_time WHERE destination.id = :id;", nativeQuery = true)
    void updateDestinationById(@Param("id") Long id, @Param("cruise_id") Long cruiseId, @Param("city_id") Long cityId, @Param("arrival_date_time") LocalDateTime arrivalDateTime, @Param("departure_date_time") LocalDateTime departureDateTime);

    void deleteAllByCruise(Cruise cruise);
}
