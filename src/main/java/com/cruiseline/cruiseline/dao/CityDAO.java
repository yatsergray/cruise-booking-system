package com.cruiseline.cruiseline.dao;

import com.cruiseline.cruiseline.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityDAO extends JpaRepository<City, Long> {

    @Modifying
    @Query(value = "UPDATE cities city SET city.country_id = :country_id, city.name = :name WHERE city.id = :id;", nativeQuery = true)
    void updateCityById(@Param("id") Long id, @Param("country_id") Long countryId, @Param("name") String name);

    List<City> findCityByNameContaining(String cityNamePart);
}
