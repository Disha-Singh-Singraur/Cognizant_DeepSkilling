package com.cognizant.springlearn.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Handout 4: Exception class for when an employee is not found
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Employee not found")
public class EmployeeNotFoundException extends Exception {

    public EmployeeNotFoundException() {
        super("Employee not found");
    }
}
