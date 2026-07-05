package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Department;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Handout 3: Department Data Access Object
 */
@Repository
public class DepartmentDao {

    public static ArrayList<Department> DEPARTMENT_LIST;

    public DepartmentDao() {
        // Load static department list from XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        DEPARTMENT_LIST = (ArrayList<Department>) context.getBean("departmentList", ArrayList.class);
    }

    public ArrayList<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}
