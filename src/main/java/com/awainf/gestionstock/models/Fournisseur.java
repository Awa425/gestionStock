package com.awainf.gestionstock.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "fournisseur")
public class Fournisseur extends EntityAbstract {

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

    @Column(name = "idEntreprise")
    private Integer idEntreprise;

    // Champs composé c-a-d on peut l'utiliser +sieur fois
    @Embedded
    private Adresse adresse;

    @OneToMany(mappedBy = "fournisseur")
    private List<CommandeFournisseur> cmdFournisseurs;

}
