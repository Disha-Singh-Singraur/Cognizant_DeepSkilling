package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * File 2, Hands on 3: DepartmentRepository
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
