package com.cruiseline.cruiseline.service.impl;

import com.cruiseline.cruiseline.dao.CountryDAO;
import com.cruiseline.cruiseline.entity.City;
import com.cruiseline.cruiseline.entity.Country;
import com.cruiseline.cruiseline.exception.NoSuchCountryExistsException;
import com.cruiseline.cruiseline.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    @Autowired
    public CountryDAO countryDAO;

    @Override
    public Country addCountry(Country country) {
        return countryDAO.save(country);
    }

    @Override
    public Country copyAndUpdateCountryById(Long countryId, Country country) throws NoSuchCountryExistsException {
        Country updatedCountry = getCountryById(countryId);
        updatedCountry.setName(country.getName());
        return addCountry(updatedCountry);
    }

    @Override
    public void removeCountryById(Long id) {
        countryDAO.deleteById(id);
    }

    @Override
    public void removeCountry(Country country) {
        countryDAO.delete(country);
    }

    @Override
    public Country getCountryById(Long id) throws NoSuchCountryExistsException {
        return Optional.of(countryDAO.getById(id)).orElseThrow(() -> new NoSuchCountryExistsException("Country with id " + id + " doesn't exist."));
    }

    @Override
    public List<Country> getAllCountries() {
        return countryDAO.findAll();
    }

    public boolean hasBookedCity(Long countryId) throws NoSuchCountryExistsException {
        Country country = getCountryById(countryId);
        for (City city : country.getCities()) {
            if (!city.getDestinations().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
