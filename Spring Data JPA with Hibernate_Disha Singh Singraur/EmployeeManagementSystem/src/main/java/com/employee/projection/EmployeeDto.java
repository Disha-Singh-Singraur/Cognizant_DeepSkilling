package com.employee.projection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * File 4, Exercise 7: Class-based (DTO) projection for Employee
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private String name;
    private double salary;
}
