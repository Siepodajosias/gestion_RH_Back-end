package com.rh.rh.entity;

import com.rh.rh.entity.enums.ERole;
import com.rh.rh.entity.enums.StatutUtilisateur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import jakarta.persistence.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;
import java.util.List;

import static com.rh.rh.entity.JpaConstants.ID;
import static com.rh.rh.entity.JpaConstants.SEQ;

@Entity
@Table(name = Rh.TABLE_NAME)
public class Rh {

    public static final String TABLE_NAME= "rh";
    public static final String TABLE_ID  = TABLE_NAME + ID;
    public static final String TABLE_SEQ = TABLE_ID + SEQ;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenoms")
    private String prenoms;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    private StatutUtilisateur statut;

    @Enumerated(EnumType.STRING)
    private ERole role;


    public UserDetails buildUser() {
        // Crée une seule autorité GrantedAuthority à partir de l'énumération ERole
        List<GrantedAuthority> authorities = Collections.singletonList(
                new SimpleGrantedAuthority(this.role.name())
        );

        // Construit et retourne l'objet UserDetails (l'implémentation par défaut de Spring Security)
        return new User(
                this.username, // Nom d'utilisateur
                this.password, // Mot de passe (déjà haché)
                authorities    // La liste des rôles/autorités
        );
    }

    public Rh() {}

    public Rh(String password, StatutUtilisateur statut, ERole role) {
        this.password= password;
        this.statut    = statut;
        this.role      = role;
    }

    public Rh(String nom, String prenoms, String username, String email, StatutUtilisateur statut, String password, ERole role) {
        this.nom           = nom;
        this.prenoms       = prenoms;
        this.username      = username;
        this.email         = email;
        this.statut        = statut;
        this.password      = password;
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

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public StatutUtilisateur getStatut() {
        return statut;
    }

    public String getPassword() {
        return password;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatut(StatutUtilisateur statut) {
        this.statut = statut;
    }

    public void setRole(ERole role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void creerOuMettreAJourRh(String username, String password, String nom, String prenoms, ERole role, StatutUtilisateur statut, String email) {
        this.username= username;
        this.password= password;
        this.nom     = nom;
        this.prenoms = prenoms;
        this.role    = role;
        this.statut  = statut;
        this.email   = email;
    }
}
