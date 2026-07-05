package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * File 2, Hands on 3 & File 3, Hands on 2 & 4 & 5: EmployeeRepository
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // File 3, Hands on 2: Get all permanent employees using optimized HQL Join Fetch
    @Query(value = "SELECT e FROM Employee e LEFT JOIN FETCH e.department d LEFT JOIN FETCH e.skillList s WHERE e.permanent = true")
    List<Employee> getAllPermanentEmployees();

    // File 3, Hands on 4: Compute average salary of a department using parameterized HQL
    @Query(value = "SELECT AVG(e.salary) FROM Employee e WHERE e.department.id = :id")
    Double getAverageSalary(@Param("id") int id);

    // File 3, Hands on 5: Get all employees using Native SQL Query
    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    List<Employee> getAllEmployeesNative();
}
