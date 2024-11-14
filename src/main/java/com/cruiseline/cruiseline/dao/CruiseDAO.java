package com.cruiseline.cruiseline.dao;

import com.cruiseline.cruiseline.entity.Cruise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface CruiseDAO extends JpaRepository<Cruise, Long> {

    @Modifying
    @Query(value = "UPDATE cruises cruise SET cruise.duration = :duration, cruise.departure_date_time = :departure_date_time, cruise.arrival_date_time = :arrival_date_time, cruise.cruise_liner_id = :cruise_liner_id WHERE cruise.id = :id", nativeQuery = true)
    void updateCruiseById(@Param("id") Long id, @Param("duration") Long duration, @Param("departure_date_time") LocalDateTime departureDateTime, @Param("arrival_date_time") LocalDateTime arrivalDateTime, @Param("cruise_liner_id") Long cruiseLinerId);
}
