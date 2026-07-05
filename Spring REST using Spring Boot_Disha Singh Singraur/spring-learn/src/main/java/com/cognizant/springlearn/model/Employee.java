package com.cognizant.springlearn.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

/**
 * Handout 3 & 4: Employee Model with JSON Date formatting and validation
 */
public class Employee {

    @NotNull(message = "Employee ID should not be null")
    private Integer id;

    @NotNull(message = "Employee name should not be null")
    @NotBlank(message = "Employee name should not be blank")
    @Size(min = 1, max = 30, message = "Employee name should be between 1 and 30 characters")
    private String name;

    @NotNull(message = "Salary should not be null")
    @Min(value = 0, message = "Salary should be zero or above")
    private Double salary;

    @NotNull(message = "Permanent field should not be null")
    private Boolean permanent;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dateOfBirth;

    @Valid
    @NotNull(message = "Department should not be null")
    private Department department;

    @Valid
    private List<Skill> skillList;

    public Employee() {
    }

    public Employee(Integer id, String name, Double salary, Boolean permanent, Date dateOfBirth, Department department, List<Skill> skillList) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.permanent = permanent;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.skillList = skillList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Boolean getPermanent() {
        return permanent;
    }

    public void setPermanent(Boolean permanent) {
        this.permanent = permanent;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    @Override
    public String toString() {
        return "Employee[id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent + "]";
    }
}
