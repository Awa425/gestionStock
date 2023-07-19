package com.awainf.gestionstock.models;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "article")
public class Article extends EntityAbstract {

    @Column(name = "codearticle")
    private String codeArticle;

    @Column(name = "designation")
    private String designation;

    @Column(name = "photo")
    private String photo;

    @Column(name = "prixunitaire")
    private BigDecimal prixUnitaire;

    @Column(name = "tauxtva")
    private BigDecimal tauxTva;

    @Column(name = "prixunitairettc")
    private BigDecimal prixUnitaireTtc;

    @ManyToOne
    @JoinColumn(name = "idCategory")
    private Categorie category;

    @OneToMany(mappedBy = "article")
    private List<LigneCommandeClient> ligneCmdClts;

    @OneToMany(mappedBy = "article")
    private List<LigneVente> ligneVentes;

    @OneToMany(mappedBy = "article")
    private List<MouvementStock> mouvementStocks;

    @Column(name = "identreprise")
    private Integer idEntreprise;

}
