package com.rh.rh.controllor.dto;

public class AuthDto {
    private String nomUtilisateur;
    private String password;

    public AuthDto(String nomUtilisateur, String password) {
        this.nomUtilisateur = nomUtilisateur;
        this.password = password;
    }

    public AuthDto() {
    }

    public String getnomUtilisateur() {
        return nomUtilisateur;
    }

    public String getPassword() {
        return password;
    }
}
