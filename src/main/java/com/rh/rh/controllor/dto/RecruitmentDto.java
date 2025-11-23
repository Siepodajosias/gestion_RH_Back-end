package com.rh.rh.controllor.dto;

import com.rh.rh.entity.Recruitment;

public class RecruitmentDto {

    private Long id;

    private String nom;

    private String prenoms;

    private String email;

    private Integer numero;

    public  RecruitmentDto(){}

    public RecruitmentDto(Recruitment recruitment) {
        this.id     = recruitment.getId();
        this.nom    = recruitment.getNom();
        this.prenoms= recruitment.getPrenoms();
        this.email  = recruitment.getEmail();
        this.numero = recruitment.getNumero();
    }

    public RecruitmentDto(String nom, String prenoms, String email, String numero) {
        this.nom    = nom;
        this.prenoms= prenoms;
        this.email  = email;
        this.numero = Integer.valueOf(numero);
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
}
