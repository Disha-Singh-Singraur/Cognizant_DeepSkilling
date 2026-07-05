package com.employee.service;

import com.employee.model.Employee;
import com.employee.projection.EmployeeDto;
import com.employee.projection.EmployeeProjection;
import com.employee.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * File 4: EmployeeService class
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PersistenceContext
    private EntityManager entityManager;

    // CRUD
    @Transactional(readOnly = true)
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Employee getById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    // Derived Query Methods
    @Transactional(readOnly = true)
    public List<Employee> getByDepartment(int deptId) {
        return employeeRepository.findByDepartmentId(deptId);
    }

    @Transactional(readOnly = true)
    public List<Employee> getByNamePrefix(String prefix) {
        return employeeRepository.findByNameStartingWith(prefix);
    }

    @Transactional(readOnly = true)
    public List<Employee> getBySalaryRange(double min, double max) {
        return employeeRepository.findBySalaryBetween(min, max);
    }

    // Named Query Methods
    @Transactional(readOnly = true)
    public List<Employee> getBySalaryGreaterThan(double salary) {
        return employeeRepository.findBySalaryGreaterThan(salary);
    }

    @Transactional(readOnly = true)
    public List<Employee> getByNameContaining(String name) {
        return employeeRepository.findByNameContaining(name);
    }

    // Pagination & Sorting
    @Transactional(readOnly = true)
    public Page<Employee> getPaginatedAndSorted(int pageNum, int pageSize, String sortBy, String direction) {
        Sort sort = Sort.by(sortBy);
        if ("DESC".equalsIgnoreCase(direction)) {
            sort = sort.descending();
        } else {
            sort = sort.ascending();
        }
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        return employeeRepository.findAll(pageable);
    }

    // Projections
    @Transactional(readOnly = true)
    public List<EmployeeProjection> getProjectedEmployees(double salary) {
        return employeeRepository.findProjectedBySalaryGreaterThan(salary);
    }

    @Transactional(readOnly = true)
    public List<EmployeeDto> getDtoEmployees(double salary) {
        return employeeRepository.findDtoBySalaryGreaterThan(salary);
    }

    // Batch processing (Exercise 8)
    @Transactional
    public void performBatchInsert(List<Employee> employees) {
        int batchSize = 50;
        for (int i = 0; i < employees.size(); i++) {
            entityManager.persist(employees.get(i));
            if (i > 0 && i % batchSize == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
        entityManager.flush();
        entityManager.clear();
    }

    @Transactional
    public void performBatchUpdate(List<Employee> employees) {
        int batchSize = 50;
        for (int i = 0; i < employees.size(); i++) {
            entityManager.merge(employees.get(i));
            if (i > 0 && i % batchSize == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
        entityManager.flush();
        entityManager.clear();
    }
}
