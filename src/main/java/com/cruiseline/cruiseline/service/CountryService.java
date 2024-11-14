package com.cruiseline.cruiseline.service;

import com.cruiseline.cruiseline.entity.Country;
import com.cruiseline.cruiseline.exception.NoSuchCountryExistsException;

import java.util.List;

public interface CountryService {
    Country addCountry(Country country);

    Country copyAndUpdateCountryById(Long countryId, Country country) throws NoSuchCountryExistsException;

    void removeCountryById(Long id);

    void removeCountry(Country country);

    Country getCountryById(Long id) throws NoSuchCountryExistsException;

    List<Country> getAllCountries();
}
