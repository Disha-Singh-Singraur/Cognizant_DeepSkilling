package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * File 1: CountryService class implementing hands-on service requirements.
 */
@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // Hands on 1: Get all countries
    @Transactional(readOnly = true)
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    // Hands on 6: Find a country based on country code
    @Transactional(readOnly = true)
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(countryCode);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country with code '" + countryCode + "' not found");
        }
        return result.get();
    }

    // Hands on 7: Add a new country
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    // Hands on 8: Update country based on code and name
    @Transactional
    public void updateCountry(String code, String name) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(code);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country with code '" + code + "' not found to update");
        }
        Country country = result.get();
        country.setName(name);
        countryRepository.save(country);
    }

    // Hands on 9: Delete a country based on code
    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }
}
