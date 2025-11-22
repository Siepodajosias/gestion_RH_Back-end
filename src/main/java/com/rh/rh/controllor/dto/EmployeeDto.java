package com.rh.rh.controllor.dto;

import com.rh.rh.entity.Department;
import com.rh.rh.entity.Employee;

public class EmployeeDto {

    private Long id;
    private String nom;

    private String prenoms;

    private String email;

    private Integer numero;

    private Department department;

    public  EmployeeDto(){}

    public EmployeeDto(Employee employee) {
        this.id        = employee.getId();
        this.nom       = employee.getNom();
        this.prenoms   = employee.getPrenoms();
        this.email     = employee.getEmail();
        this.numero    = employee.getNumero();
        this.department= employee.getDepartment();
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public String getEmail() {
        return email;
    }

    public Integer getNumero() {
        return numero;
    }

    public Department getDepartment() {
        return department;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
