package com.cognizant.ormlearn.service.exception;

/**
 * File 1, Hands on 6: Custom exception thrown when a country is not found by its code.
 */
public class CountryNotFoundException extends Exception {
    
    public CountryNotFoundException(String message) {
        super(message);
    }
}
