package com.cognizant.springlearn.service;

import com.cognizant.springlearn.dao.DepartmentDao;
import com.cognizant.springlearn.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Handout 3: DepartmentService class
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Transactional(readOnly = true)
    public ArrayList<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }
}
