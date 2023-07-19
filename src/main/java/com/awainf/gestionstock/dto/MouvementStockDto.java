package com.awainf.gestionstock.dto;

import java.math.BigDecimal;
import java.time.Instant;

import com.awainf.gestionstock.models.MouvementStock;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MouvementStockDto {

    private Integer id;

    private ArticleDto article;

    private Instant dateMvt;

    private BigDecimal quantite;

    private Integer idEntreprise;

    /* Mapping MovementStock -> MouvementStockDto */
    public static MouvementStockDto fromEntity(MouvementStock mouvementStock) {
        if (mouvementStock == null) {
            return null;
            // TODO throw exception
        }

        return MouvementStockDto.builder()
                .id(mouvementStock.getId())
                .dateMvt(mouvementStock.getDateMvt())
                .quantite(mouvementStock.getQuantite())
                .article(ArticleDto.fromEntity(mouvementStock.getArticle()))
                .idEntreprise(mouvementStock.getIdEntreprise())
                .build();
    }

    /* Mapping MovementStockDto -> MouvementStock */
    public static MouvementStock toEntity(MouvementStockDto mouvementStockDto) {
        if (mouvementStockDto == null) {
            return null;
            // TODO throw exception
        }

        MouvementStock mouvementStock = new MouvementStock();
        mouvementStock.setId(mouvementStockDto.getId());
        mouvementStock.setDateMvt(mouvementStockDto.getDateMvt());
        mouvementStock.setQuantite(mouvementStockDto.getQuantite());
        mouvementStock.setArticle(ArticleDto.toEntity(mouvementStockDto.getArticle()));
        mouvementStock.setIdEntreprise(mouvementStockDto.getIdEntreprise());
        return mouvementStock;
    }

}
