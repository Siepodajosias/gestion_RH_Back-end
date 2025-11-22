package com.rh.rh.entity;

import jakarta.persistence.*;

import static com.rh.rh.entity.JpaConstants.ID;
import static com.rh.rh.entity.JpaConstants.SEQ;

@Entity
@Table(name = Recruitment.TABLE_NAME)
public class Recruitment {

    public static final String TABLE_NAME= "recruitment";
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

    public  Recruitment(){}

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
}
