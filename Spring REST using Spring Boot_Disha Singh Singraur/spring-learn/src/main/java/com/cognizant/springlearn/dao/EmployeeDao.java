package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Handout 3 & 4: Employee Data Access Object
 */
@Repository
public class EmployeeDao {

    public static ArrayList<Employee> EMPLOYEE_LIST;

    public EmployeeDao() {
        // Load static employee list from XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList", ArrayList.class);
    }

    public ArrayList<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }

    // Handout 4: Update employee details in static list or throw exception
    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        boolean found = false;
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            Employee emp = EMPLOYEE_LIST.get(i);
            if (emp.getId().equals(employee.getId())) {
                EMPLOYEE_LIST.set(i, employee);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new EmployeeNotFoundException();
        }
    }

    // Handout 4: Delete employee details from static list or throw exception
    public void deleteEmployee(int id) throws EmployeeNotFoundException {
        Employee toRemove = null;
        for (Employee emp : EMPLOYEE_LIST) {
            if (emp.getId() == id) {
                toRemove = emp;
                break;
            }
        }
        if (toRemove == null) {
            throw new EmployeeNotFoundException();
        }
        EMPLOYEE_LIST.remove(toRemove);
    }
}
