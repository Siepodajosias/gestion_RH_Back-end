package com.rh.rh.entity;

import jakarta.persistence.*;

import static com.rh.rh.entity.JpaConstants.ID;
import static com.rh.rh.entity.JpaConstants.SEQ;

@Entity
@Table(name = Employee.TABLE_NAME)
public class Employee {

    public static final String TABLE_NAME= "employee";
    public static final String TABLE_ID  = TABLE_NAME + ID;
    public static final String TABLE_SEQ = TABLE_ID + SEQ;

    @Id
    @SequenceGenerator(name = TABLE_SEQ, sequenceName = TABLE_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_SEQ)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenoms")
    private String prenoms;

    @Column(name = "email")
    private String email;

    @Column(name = "numero")
    private Integer numero;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = Department.TABLE_ID, nullable = false)
    private Department department;

    public Employee() {}

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
