package com.awainf.gestionstock.dto;

import java.math.BigDecimal;
// import java.util.List;
// import java.util.stream.Collectors;

import com.awainf.gestionstock.models.Article;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticleDto {

    private Integer id;

    private String codeArticle;

    private String designation;

    private String photo;

    private BigDecimal prixUnitaire;

    private BigDecimal tauxTva;

    private BigDecimal prixUnitaireTtc;

    private CategorieDto category;

    private Integer idEntreprise;

    // private List<LigneCommandeClientDto> ligneCmdClts;

    // private List<LigneVenteDto> ligneVentes;

    // private List<MouvementStockDto> mouvementStocks;

    /* Mapping Article -> ArticleDto */
    public static ArticleDto fromEntity(Article article) {
        if (article == null) {
            return null;
            // TODO throw exception
        }

        return ArticleDto.builder()
                .codeArticle(article.getCodeArticle())
                .designation(article.getDesignation())
                .photo(article.getPhoto())
                .prixUnitaire(article.getPrixUnitaire())
                .tauxTva(article.getTauxTva())
                .prixUnitaireTtc(article.getPrixUnitaireTtc())
                .idEntreprise(article.getIdEntreprise())
                .category(CategorieDto.fromEntity(article.getCategory()))

                .build();
    }

    /* Mapping ArticleDto -> Article */
    public static Article toEntity(ArticleDto articleDto) {
        if (articleDto == null) {
            return null;
            // TODO throw excption
        }

        Article article = new Article();
        article.setId(articleDto.getId());
        article.setCodeArticle(articleDto.getCodeArticle());
        article.setDesignation(articleDto.getDesignation());
        article.setPhoto(articleDto.getPhoto());
        article.setPrixUnitaire(articleDto.getPrixUnitaire());
        article.setTauxTva(articleDto.getTauxTva());
        article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
        article.setIdEntreprise(articleDto.getIdEntreprise());
        article.setCategory(CategorieDto.toEntity(articleDto.getCategory()));

        return article;
    }

}
