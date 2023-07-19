package com.awainf.gestionstock.models;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.EqualsAndHashCode;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
public class Users extends EntityAbstract {

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "mail")
    private String mail;

    @Column(name = "photo")
    private String photo;

    // Champs composé c-a-d on peut l'utiliser +sieur fois
    @Embedded
    private Adresse adresse;

    @ManyToOne
    @JoinColumn(name = "id Entreprise")
    private Entreprise entreprise;

    @Column(name = "datedenaissance")
    private Instant dateDeNaissance;

    @Column(name = "motdepasse")
    private String moteDePasse;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @JsonIgnore
    private List<Roles> roles;
}
