package com.awainf.gestionstock.dto;

import java.math.BigDecimal;

import com.awainf.gestionstock.models.LigneVente;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneVenteDto {

    private Integer id;

    private ArticleDto article;

    private VenteDto vente;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    private Integer idEntreprise;

    /* Mapping LigneVente -> LigneVenteDto */
    public static LigneVenteDto formEntity(LigneVente ligneVente) {
        if (ligneVente == null) {
            return null;
            // TODO throw exception
        }

        return LigneVenteDto.builder()
                .id(ligneVente.getId())
                .vente(VenteDto.fromEntity(ligneVente.getVente()))
                .article(ArticleDto.fromEntity(ligneVente.getArticle()))
                .quantite(ligneVente.getQuantite())
                .prixUnitaire(ligneVente.getPrixUnitaire())
                .idEntreprise(ligneVente.getIdEntreprise())
                .build();
    }

    /* Mapping LigneVenteDto -> LigneVente */
    public static LigneVente toEntity(LigneVenteDto ligneVenteDto) {
        if (ligneVenteDto == null) {
            return null;
            // TODO throw exception
        }

        LigneVente ligneVente = new LigneVente();
        ligneVente.setId(ligneVenteDto.getId());
        ligneVente.setVente(VenteDto.toEntity(ligneVenteDto.getVente()));
        ligneVente.setArticle(ArticleDto.toEntity(ligneVenteDto.getArticle()));
        ligneVente.setQuantite(ligneVenteDto.getQuantite());
        ligneVente.setPrixUnitaire(ligneVenteDto.getPrixUnitaire());
        ligneVente.setIdEntreprise(ligneVenteDto.getIdEntreprise());

        return ligneVente;
    }

}
