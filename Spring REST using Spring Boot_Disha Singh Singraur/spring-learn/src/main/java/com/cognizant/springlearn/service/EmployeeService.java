package com.cognizant.springlearn.service;

import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Handout 3 & 4: EmployeeService class
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional(readOnly = true)
    public ArrayList<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Transactional
    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        employeeDao.updateEmployee(employee);
    }

    @Transactional
    public void deleteEmployee(int id) throws EmployeeNotFoundException {
        employeeDao.deleteEmployee(id);
    }
}
