package com.employee.controller;

import com.employee.model.Employee;
import com.employee.projection.EmployeeDto;
import com.employee.projection.EmployeeProjection;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * File 4: REST Controller for Employees
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Get all employees
    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable int id) {
        Employee emp = employeeService.getById(id);
        if (emp != null) {
            return ResponseEntity.ok(emp);
        }
        return ResponseEntity.notFound().build();
    }

    // Create a new employee
    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Employee saved = employeeService.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Update an existing employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable int id, @RequestBody Employee employeeDetails) {
        Employee emp = employeeService.getById(id);
        if (emp == null) {
            return ResponseEntity.notFound().build();
        }
        emp.setName(employeeDetails.getName());
        emp.setSalary(employeeDetails.getSalary());
        if (employeeDetails.getDepartment() != null) {
            emp.setDepartment(employeeDetails.getDepartment());
        }
        Employee updated = employeeService.save(emp);
        return ResponseEntity.ok(updated);
    }

    // Delete employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Employee emp = employeeService.getById(id);
        if (emp == null) {
            return ResponseEntity.notFound().build();
        }
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Custom Query: Get by Department ID (Exercise 3)
    @GetMapping("/department/{deptId}")
    public List<Employee> getByDepartment(@PathVariable int deptId) {
        return employeeService.getByDepartment(deptId);
    }

    // Custom Query: Search by Name Prefix (Exercise 3)
    @GetMapping("/search/prefix")
    public List<Employee> getByNamePrefix(@RequestParam String prefix) {
        return employeeService.getByNamePrefix(prefix);
    }

    // Custom Query: Search by Salary Range (Exercise 3)
    @GetMapping("/search/salary-range")
    public List<Employee> getBySalaryRange(@RequestParam double min, @RequestParam double max) {
        return employeeService.getBySalaryRange(min, max);
    }

    // Named Query: Search by Salary Greater Than (Exercise 4)
    @GetMapping("/search/salary-greater")
    public List<Employee> getBySalaryGreaterThan(@RequestParam double salary) {
        return employeeService.getBySalaryGreaterThan(salary);
    }

    // Named Query: Search by Name Containing (Exercise 4)
    @GetMapping("/search/name-contains")
    public List<Employee> getByNameContaining(@RequestParam String name) {
        return employeeService.getByNameContaining(name);
    }

    // Pagination & Sorting (Exercise 5)
    @GetMapping("/page")
    public Page<Employee> getPaginatedAndSorted(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "ASC") String direction) {
        return employeeService.getPaginatedAndSorted(page, size, sortBy, direction);
    }

    // Interface-based Projection (Exercise 7)
    @GetMapping("/projection/interface")
    public List<EmployeeProjection> getInterfaceProjections(@RequestParam double salary) {
        return employeeService.getProjectedEmployees(salary);
    }

    // Class-based Projection (Exercise 7)
    @GetMapping("/projection/class")
    public List<EmployeeDto> getClassProjections(@RequestParam double salary) {
        return employeeService.getDtoEmployees(salary);
    }

    // Batch Processing Demonstration Endpoint (Exercise 8)
    @PostMapping("/batch-demo")
    public ResponseEntity<String> runBatchDemo() {
        List<Employee> list = new ArrayList<>();
        // Mock insert 200 employees
        for (int i = 1; i <= 200; i++) {
            Employee e = new Employee();
            e.setName("BatchEmp " + i);
            e.setSalary(40000 + i * 10);
            list.add(e);
        }
        employeeService.performBatchInsert(list);

        // Fetch back and update salaries in batch
        List<Employee> seeded = employeeService.getByNamePrefix("BatchEmp ");
        for (Employee e : seeded) {
            e.setSalary(e.getSalary() + 5000); // raise salary
        }
        employeeService.performBatchUpdate(seeded);

        return ResponseEntity.ok("Batch inserts & updates for 200 employees completed successfully!");
    }
}
