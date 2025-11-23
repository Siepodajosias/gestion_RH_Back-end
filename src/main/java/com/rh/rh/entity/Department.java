package com.rh.rh.entity;

import jakarta.persistence.*;

import java.util.List;

import static com.rh.rh.entity.JpaConstants.ID;
import static com.rh.rh.entity.JpaConstants.SEQ;

@Entity
@Table(name = Department.TABLE_NAME)
public class Department {

    public static final String TABLE_NAME= "department";
    public static final String TABLE_ID  = TABLE_NAME + ID;
    public static final String TABLE_SEQ = TABLE_ID + SEQ;

    @Id
    @SequenceGenerator(name = TABLE_SEQ, sequenceName = TABLE_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_SEQ)
    private Long id;

    @Column(name = "designation")
    private String designation;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
    private List<Employee> employee;

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
