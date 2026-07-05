package com.employee.repository;

import com.employee.model.Employee;
import com.employee.projection.EmployeeDto;
import com.employee.projection.EmployeeProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * File 4: EmployeeRepository defining CRUD, custom query methods, named queries, and projections
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Exercise 3: Derived Query Methods
    List<Employee> findByDepartmentId(int deptId);
    List<Employee> findByNameStartingWith(String prefix);
    List<Employee> findBySalaryBetween(double minSalary, double maxSalary);

    // Exercise 4: Named Query Methods
    List<Employee> findBySalaryGreaterThan(@Param("salary") double salary);
    List<Employee> findByNameContaining(@Param("name") String name);

    // Exercise 7: Interface-based Projection
    @Query("SELECT e.name as name, e.salary as salary FROM Employee e WHERE e.salary > :salary")
    List<EmployeeProjection> findProjectedBySalaryGreaterThan(@Param("salary") double salary);

    // Exercise 7: Class-based (DTO) Projection using JPQL Constructor Expression
    @Query("SELECT new com.employee.projection.EmployeeDto(e.name, e.salary) FROM Employee e WHERE e.salary > :salary")
    List<EmployeeDto> findDtoBySalaryGreaterThan(@Param("salary") double salary);
}
