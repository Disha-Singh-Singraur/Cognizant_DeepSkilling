package com.employee;

import com.employee.model.Department;
import com.employee.model.Employee;
import com.employee.repository.DepartmentRepository;
import com.employee.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * File 4: Main Application Class for EmployeeManagementSystem
 */
@SpringBootApplication
public class EmployeeManagementSystemApplication {

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("  STARTING EMPLOYEE MANAGEMENT SYSTEM (Lab)     ");
        System.out.println("=================================================");
        SpringApplication.run(EmployeeManagementSystemApplication.class, args);
    }

    @Bean
    public CommandLineRunner emsSeeder(
            DepartmentRepository departmentRepository,
            EmployeeRepository employeeRepository) {
        return (args) -> {
            System.out.println("\n[EMS Initialization] Seeding H2 Database...");

            // 1. Seed Departments
            Department engineering = new Department("Engineering");
            Department hr = new Department("HR");
            Department sales = new Department("Sales");
            departmentRepository.saveAll(Arrays.asList(engineering, hr, sales));

            // 2. Seed Employees
            Employee alice = new Employee("Alice Johnson", 85000.0, engineering);
            Employee bob = new Employee("Bob Smith", 62000.0, engineering);
            Employee charlie = new Employee("Charlie Brown", 50000.0, hr);
            Employee david = new Employee("David Miller", 75000.0, sales);
            Employee eve = new Employee("Eve Davis", 95000.0, engineering);
            employeeRepository.saveAll(Arrays.asList(alice, bob, charlie, david, eve));

            System.out.println("[EMS Initialization] Database seeding completed successfully!\n");
        };
    }
}
