package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Handout 2 & 4: CountryController REST controller
 */
@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    // Handout 2: India country details
    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public Country getCountryIndia() {
        LOGGER.info("START getCountryIndia");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("in", Country.class);
        LOGGER.info("END getCountryIndia");
        return country;
    }

    // Handout 2 & 4: Get all countries
    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        LOGGER.info("START getAllCountries");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> list = (ArrayList<Country>) context.getBean("countryList", ArrayList.class);
        LOGGER.info("END getAllCountries");
        return list;
    }

    // Handout 2 & 4: Get specific country based on code
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable("code") String code) throws CountryNotFoundException {
        LOGGER.info("START getCountry: {}", code);
        Country country = countryService.getCountry(code);
        LOGGER.info("END getCountry");
        return country;
    }

    // Handout 4: Add a new country with validation
    @PostMapping("/countries")
    public Country addCountry(@RequestBody @Valid Country country) {
        LOGGER.info("START addCountry: {}", country);
        LOGGER.info("END addCountry");
        return country;
    }
}
