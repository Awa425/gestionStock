package com.awainf.gestionstock.dto;

import java.util.List;

import com.awainf.gestionstock.models.Categorie;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategorieDto {

    private Integer id;

    private String designation;

    private String code;

    private Integer idEntreprise;

    @JsonIgnore
    private List<ArticleDto> Articles;

    /* Mapping Category -> CategoryDto */
    public static CategorieDto fromEntity(Categorie categorie) {
        if (categorie == null) {
            return null;
            // TODO throw an exception
        }

        return CategorieDto.builder()
                .id(categorie.getId())
                .code(categorie.getCode())
                .designation(categorie.getDesignation())
                .idEntreprise(categorie.getIdEntreprise())
                .build();
    }

    /* Mapping CategoryDto -> Category */
    public static Categorie toEntity(CategorieDto categorieDto) {
        if (categorieDto == null) {
            return null;
            // TODO throw exception
        }

        Categorie categorie = new Categorie();
        categorie.setId(categorieDto.getId());
        categorie.setCode(categorieDto.getCode());
        categorie.setDesignation(categorieDto.getDesignation());
        categorie.setIdEntreprise(categorieDto.getIdEntreprise());
        return categorie;

    }

}
