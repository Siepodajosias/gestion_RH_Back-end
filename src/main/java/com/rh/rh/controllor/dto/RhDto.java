package com.rh.rh.controllor.dto;

import com.rh.rh.entity.enums.ERole;
import com.rh.rh.entity.Rh;
import com.rh.rh.entity.enums.StatutUtilisateur;

public class RhDto {

    private Long id;

    private String nom;

    private String prenoms;

    private String nomUtilisateur;

    private String email;
    private String motDePasse;

    private StatutUtilisateur statut;

    private ERole role;

    /**
     * Constructeur par défaut.
     */
    public RhDto() {}

    /**
     * Constructeur paramétré
     *
     * @param rh l'utilisateur
     */
    public RhDto(Rh rh) {
        this.id            = rh.getId();
        this.nom           = rh.getNom();
        this.prenoms       = rh.getPrenoms();
        this.nomUtilisateur= rh.getUsername();
        this.statut        = rh.getStatut();
        this.motDePasse    = rh.getPassword();
        this.role          = rh.getRole();
        this.email         = rh.getEmail();
    }

    public RhDto(String nom, String prenoms, String nomUtilisateur, String email, String motDePasse, ERole role) {
        this.nom           = nom;
        this.prenoms       = prenoms;
        this.nomUtilisateur= nomUtilisateur;
        this.motDePasse    = motDePasse;
        this.role          = role;
        this.email         = email;
    }

    // Création des getters

    public String getNom() {
        return nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public StatutUtilisateur getStatut() {
        return statut;
    }

    public ERole getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    // Création des setters

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setStatut(StatutUtilisateur statut) {
        this.statut = statut;
    }

    public void setRole(ERole role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
