package com.rh.rh.controllor.dto;

import com.rh.rh.entity.enums.ERole;
import com.rh.rh.entity.Rh;
import com.rh.rh.entity.enums.StatutUtilisateur;

public class RhDto {

    private Long id;

    private String nom;

    private String prenoms;

    private String nomUtilisateur;

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
        this.nomUtilisateur= rh.getNomUtilisateur();
        this.statut        = rh.getStatut();
        this.motDePasse    = rh.getMotDePasse();
        this.role          = rh.getRole();
    }

    public RhDto(Long id,String nom, String prenoms, String nomUtilisateur, String motDePasse, ERole role) {
        this.id = id;
        this.nom = nom;
        this.prenoms = prenoms;
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
        this.role = role;
    }

    // Création des getters

    public Long getId() {
        return id;
    }

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


   // Création des setters

    public void setId(Long id) {
        this.id = id;
    }

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
}
