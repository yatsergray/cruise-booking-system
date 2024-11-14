package com.cruiseline.cruiseline.dao;

import com.cruiseline.cruiseline.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CountryDAO extends JpaRepository<Country, Long> {

    @Modifying
    @Query(value = "UPDATE countries country SET country.name = :name WHERE country.id = :id;", nativeQuery = true)
    void updateCountryBuId(@Param("id") Long id, @Param("name") String name);
}
