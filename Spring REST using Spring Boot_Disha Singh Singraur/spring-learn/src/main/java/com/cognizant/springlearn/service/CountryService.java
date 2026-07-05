package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Handout 2: CountryService class
 */
@Service
public class CountryService {

    public Country getCountry(String code) throws CountryNotFoundException {
        // Load country list from country.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        ArrayList<Country> list = (ArrayList<Country>) context.getBean("countryList", ArrayList.class);

        // Perform case-insensitive match
        for (Country country : list) {
            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }
        throw new CountryNotFoundException();
    }
}
