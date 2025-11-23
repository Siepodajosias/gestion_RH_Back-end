package com.rh.rh.controllor.dto;

import com.rh.rh.entity.Department;
import com.rh.rh.entity.Employee;

import java.util.List;

public class DepartmentDto {

    private Long id;
    private String designation;

    private List<Employee> employee;
    public DepartmentDto(){}

    public DepartmentDto(Department department) {
        this.id         = department.getId();
        this.designation= department.getDesignation();
        this.employee   = department.getEmployee();
    }

    public DepartmentDto(String designation) {
        this.designation= designation;
    }

    public Long getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
