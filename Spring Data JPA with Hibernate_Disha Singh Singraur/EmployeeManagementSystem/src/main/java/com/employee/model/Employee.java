package com.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * File 4, Exercise 1, 2, 4: Employee Entity Class with Named Queries
 */
@Entity
@Table(name = "ems_employee")
@NamedQueries({
    @NamedQuery(
        name = "Employee.findBySalaryGreaterThan",
        query = "SELECT e FROM Employee e WHERE e.salary > :salary"
    ),
    @NamedQuery(
        name = "Employee.findByNameContaining",
        query = "SELECT e FROM Employee e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%'))"
    )
})
@Getter
@Setter
@NoArgsConstructor
public class Employee extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String name;

    private double salary;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    @JsonIgnoreProperties("employeeList")
    private Department department;

    public Employee(String name, double salary, Department department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}
