package com.cruiseline.cruiseline.dao;

import com.cruiseline.cruiseline.entity.CruiseLiner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface CruiseLinerDAO extends JpaRepository<CruiseLiner, Long> {

    @Modifying
    @Query(value = "UPDATE cruise_liners SET creation_year = ?, length = ?, width = ?, cruising_speed = ?, staff_amount = ?, passengers_amount = ?, decks_amount = ?, cabins_amount = ? WHERE id = ?;", nativeQuery = true)
    void updateCruiseLinerById(@Param("id") Long id, @Param("creation_year") String creationYear, @Param("length") BigDecimal length, @Param("width") BigDecimal width, @Param("cruising_speed") BigDecimal cruisingSpeed, @Param("staff_amount") Long staffAmount, @Param("passengers_amount") Long passengersAmount, @Param("decks_amount") Long decksAmount, @Param("cabins_amount") Long cabinsAmount, @Param("passengers_lifts_amount") Long passengersLiftsAmount);

    List<CruiseLiner> findCruiseLinerByNameContaining(String cruiseLinerNamePart);
}
