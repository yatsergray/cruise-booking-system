package com.cruiseline.cruiseline.dao;

import com.cruiseline.cruiseline.entity.Cabin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface CabinDAO extends JpaRepository<Cabin, Long> {

    @Modifying
    @Query(value = "UPDATE cabins SET cruise_liner_id = ?, class_id = ?, deck_number = ?, capacity = ?, adult_daily_cost = ?, child_daily_cost = ? WHERE id = ?;", nativeQuery = true)
    void updateCabinById(@Param("id") Long id, @Param("cruise_liner_id") Long cruiseLinerId, @Param("class_id") Long classId, @Param("deck_number") Long deckNumber, @Param("capacity") Long capacity, @Param("adult_daily_cost") BigDecimal adultDailyCost, @Param("child_daily_cost") BigDecimal childDailyCost);
}
