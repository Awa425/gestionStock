package com.awainf.gestionstock.dto;

import java.math.BigDecimal;

import com.awainf.gestionstock.models.LigneCommandeClient;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeClientDto {

    private Integer id;

    private ArticleDto article;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    private Integer idEntreprise;

    @JsonIgnore
    private CommandeClientDto commandeClient;

    /* Mapping fronm CommandeClient -> CommandeClientDto */
    public static LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient) {
        if (ligneCommandeClient == null) {
            return null;
        }
        return LigneCommandeClientDto.builder()
                .id(ligneCommandeClient.getId())
                .article(ArticleDto.fromEntity(ligneCommandeClient.getArticle()))                .quantite(ligneCommandeClient.getQuantite())
                .prixUnitaire(ligneCommandeClient.getPrixUnitaire())
                .idEntreprise(ligneCommandeClient.getIdEntreprise())
                .build();
    }

    /* Mapping fronm CommandeClient -> CommandeClientDto */
    public static LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto) {
        if (ligneCommandeClientDto == null) {
            return null;
        }

        LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
        ligneCommandeClient.setId(ligneCommandeClientDto.getId());
        ligneCommandeClient.setArticle(ArticleDto.toEntity(ligneCommandeClientDto.getArticle()));
        ligneCommandeClient.setPrixUnitaire(ligneCommandeClientDto.getPrixUnitaire());
        ligneCommandeClient.setQuantite(ligneCommandeClientDto.getQuantite());
        ligneCommandeClient.setIdEntreprise(ligneCommandeClientDto.getIdEntreprise());

        return ligneCommandeClient;
    }
}
