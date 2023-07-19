package com.awainf.gestionstock.dto;

import java.math.BigDecimal;

import com.awainf.gestionstock.models.LigneCommandeFournisseur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeFournisseurDto {

    private Integer id;

    private CommandeFournisseurDto commandeFournisseur;

    private ArticleDto article;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    private Integer idEntreprise;

    /* Mappin LigneCommandeFournisseur -> LigneCommandeFournisseurDto */
    public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur) {
        if (ligneCommandeFournisseur == null) {
            return null;
        }
        return LigneCommandeFournisseurDto.builder()
                .id(ligneCommandeFournisseur.getId())
                .quantite(ligneCommandeFournisseur.getQuantite())
                .prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
                .idEntreprise(ligneCommandeFournisseur.getIdEntreprise())
                .article(ArticleDto.fromEntity(ligneCommandeFournisseur.getArticle()))
                .build();
    }

    /* Mappin LigneCommandeFournisseurDto -> LigneCommandeFournisseur */
    public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto ligneCommandeFournisseurDto) {
        if (ligneCommandeFournisseurDto == null) {
            return null;
        }

        LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
        ligneCommandeFournisseur.setId(ligneCommandeFournisseurDto.getId());
        ligneCommandeFournisseur.setArticle(ArticleDto.toEntity(ligneCommandeFournisseurDto.getArticle()));
        ligneCommandeFournisseur.setPrixUnitaire(ligneCommandeFournisseurDto.getPrixUnitaire());
        ligneCommandeFournisseur.setQuantite(ligneCommandeFournisseurDto.getQuantite());
        ligneCommandeFournisseur.setIdEntreprise(ligneCommandeFournisseurDto.getIdEntreprise());

        return ligneCommandeFournisseur;
    }

}
