package com.employee.controller;

import com.employee.model.Department;
import com.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * File 4: REST Controller for Departments
 */
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAll() {
        return departmentService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getById(@PathVariable int id) {
        Department dept = departmentService.getById(id);
        if (dept != null) {
            return ResponseEntity.ok(dept);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Department> create(@RequestBody Department department) {
        Department saved = departmentService.save(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> update(@PathVariable int id, @RequestBody Department departmentDetails) {
        Department dept = departmentService.getById(id);
        if (dept == null) {
            return ResponseEntity.notFound().build();
        }
        dept.setName(departmentDetails.getName());
        Department updated = departmentService.save(dept);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Department dept = departmentService.getById(id);
        if (dept == null) {
            return ResponseEntity.notFound().build();
        }
        departmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
