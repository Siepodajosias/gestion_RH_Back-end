package com.rh.rh.entity;

import jakarta.persistence.*;

import static com.rh.rh.entity.JpaConstants.ID;
import static com.rh.rh.entity.JpaConstants.SEQ;

@Entity
@Table(name = Dashboard.TABLE_NAME)
public class Dashboard {

    public static final String TABLE_NAME= "dashboard";
    public static final String TABLE_ID  = TABLE_NAME + ID;
    public static final String TABLE_SEQ = TABLE_ID + SEQ;

    @Id
    @SequenceGenerator(name = TABLE_SEQ, sequenceName = TABLE_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_SEQ)
    private Long id;

    @Column(name = "designation")
    private String designation;
}
