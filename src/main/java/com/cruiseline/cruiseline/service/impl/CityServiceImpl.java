package com.cruiseline.cruiseline.service.impl;

import com.cruiseline.cruiseline.dao.CityDAO;
import com.cruiseline.cruiseline.entity.City;
import com.cruiseline.cruiseline.exception.NoSuchCityExistsException;
import com.cruiseline.cruiseline.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDAO cityDAO;

    @Override
    public City addCity(City city) {
        return cityDAO.save(city);
    }

    @Override
    public City copyAndUpdateCityById(Long cityId, City city) throws NoSuchCityExistsException {
        City updatedCity = getCityById(cityId);
        updatedCity.setName(city.getName());
        updatedCity.setCountry(city.getCountry());
        return addCity(updatedCity);
    }

    @Override
    public void removeCityById(Long id) {
        cityDAO.deleteById(id);
    }

    @Override
    public void removeCity(City city) {
        cityDAO.delete(city);
    }

    @Override
    public City getCityById(Long id) throws NoSuchCityExistsException {
        return Optional.of(cityDAO.getById(id)).orElseThrow(() -> new NoSuchCityExistsException("City with id " + id + " doesn't exist."));
    }

    @Override
    public List<City> getAllCities() {
        return cityDAO.findAll();
    }

    public boolean isBooked(Long cityId) throws NoSuchCityExistsException {
        return !getCityById(cityId).getDestinations().isEmpty();
    }
}
