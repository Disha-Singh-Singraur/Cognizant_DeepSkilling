package com.employee.repository;

import com.employee.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * File 4: DepartmentRepository interface
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
