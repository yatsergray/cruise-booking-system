package com.cruiseline.cruiseline.service;

import com.cruiseline.cruiseline.entity.City;
import com.cruiseline.cruiseline.exception.NoSuchCityExistsException;

import java.util.List;

public interface CityService {
    City addCity(City city);

    City copyAndUpdateCityById(Long cityId, City city) throws NoSuchCityExistsException;

    void removeCityById(Long id);

    void removeCity(City city);

    City getCityById(Long id) throws NoSuchCityExistsException;

    List<City> getAllCities();

}
