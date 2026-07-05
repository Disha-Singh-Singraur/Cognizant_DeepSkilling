package com.cognizant.springlearn.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handout 1, Hands on 4 & Handout 4: Country Model with validation and logging
 */
public class Country {

    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    @NotNull(message = "Country code should not be null")
    @Size(min = 2, max = 2, message = "Country code should be 2 characters")
    private String code;

    @NotNull(message = "Country name should not be null")
    private String name;

    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }

    public Country(String code, String name) {
        LOGGER.debug("Inside Country Parameterized Constructor: {}, {}", code, name);
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        LOGGER.debug("Inside getCode(): {}", code);
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("Inside setCode(): {}", code);
        this.code = code;
    }

    public String getName() {
        LOGGER.debug("Inside getName(): {}", name);
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("Inside setName(): {}", name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country[code=" + code + ", name=" + name + "]";
    }
}
