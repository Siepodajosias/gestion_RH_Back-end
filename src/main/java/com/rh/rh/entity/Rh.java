package com.rh.rh.entity;

import com.rh.rh.entity.enums.ERole;
import com.rh.rh.entity.enums.StatutUtilisateur;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import jakarta.persistence.*;

import static com.rh.rh.entity.JpaConstants.ID;
import static com.rh.rh.entity.JpaConstants.SEQ;
import static java.util.Collections.singleton;

@Entity
@Table(name = Rh.TABLE_NAME)
public class Rh {

    public static final String TABLE_NAME= "rh";
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

    @Column(name = "nomUtilisateur")
    private String nomUtilisateur;

    @Column(name = "email")
    private String email;

    @Column(name = "motDePasse")
    private String motDePasse;

    @Enumerated(EnumType.STRING)
    private StatutUtilisateur statut;

    @Enumerated(EnumType.STRING)
    private ERole role;

    public User buildUser() {
        return new User(nomUtilisateur, motDePasse, singleton(new SimpleGrantedAuthority(role.name())));
    }

    public Rh() {}

    public Rh(String motDePasse, StatutUtilisateur statut, ERole role) {
        this.motDePasse= motDePasse;
        this.statut    = statut;
        this.role      = role;
    }

    public Rh(Long id, String nom, String prenoms, String nomUtilisateur, String email, StatutUtilisateur statut, String motDePasse, ERole role) {
        this.id            = id;
        this.nom           = nom;
        this.prenoms       = prenoms;
        this.nomUtilisateur= nomUtilisateur;
        this.email         = email;
        this.statut        = statut;
        this.motDePasse    = motDePasse;
        this.role          = role;
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

    public String getEmail() {
        return email;
    }

    public StatutUtilisateur getStatut() {
        return statut;
    }

    public String getMotDePasse() {
        return motDePasse;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatut(StatutUtilisateur statut) {
        this.statut = statut;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void creerOuMettreAJourRh(String nomUtilisateur, String motDePasse, String nom, String prenoms, ERole role, StatutUtilisateur statut) {
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
        this.nom = nom;
        this.prenoms = prenoms;
        this.role = role;
        this.statut = statut;
    }
}
