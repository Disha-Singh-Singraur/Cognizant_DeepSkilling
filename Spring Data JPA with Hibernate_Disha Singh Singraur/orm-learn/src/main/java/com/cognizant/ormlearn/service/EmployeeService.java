package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * File 2, Hands on 4 & File 3, Hands on 2 & 4 & 5: EmployeeService
 */
@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public Employee get(int id) {
        LOGGER.info("Start get employee id: {}", id);
        return employeeRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Employee employee) {
        LOGGER.info("Start save employee: {}", employee.getName());
        employeeRepository.save(employee);
        LOGGER.info("End save employee");
    }

    @Transactional(readOnly = true)
    public List<Employee> getAllPermanentEmployees() {
        LOGGER.info("Start getAllPermanentEmployees");
        return employeeRepository.getAllPermanentEmployees();
    }

    @Transactional(readOnly = true)
    public double getAverageSalary(int id) {
        LOGGER.info("Start getAverageSalary for department: {}", id);
        Double avg = employeeRepository.getAverageSalary(id);
        return avg != null ? avg : 0.0;
    }

    @Transactional(readOnly = true)
    public List<Employee> getAllEmployeesNative() {
        LOGGER.info("Start getAllEmployeesNative");
        return employeeRepository.getAllEmployeesNative();
    }
}
