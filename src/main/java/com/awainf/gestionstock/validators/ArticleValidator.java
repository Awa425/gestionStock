package com.awainf.gestionstock.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.awainf.gestionstock.dto.ArticleDto;

public class ArticleValidator {

    // verifie si les champs sont vodes
    public static List<String> validate(ArticleDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez entrer le code article");
            errors.add("Veuillez renseigner le prix unitaire de l'article");
            errors.add("Veuillez renseigner le taux TVA de l'article");
            errors.add("Veuillez selectionner une category pour l'article");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getCodeArticle())) {
            errors.add("Veuillez entrer le code article");
        }
        if (dto.getPrixUnitaire() == null) {
            errors.add("Veuillez renseigner le prix unitaire de l'article");
        }
        if (dto.getTauxTva() == null) {
            errors.add("Veuillez renseigner le taux TVA de l'article");
        }
        if (dto.getCategory() == null) {
            errors.add("Veuillez selectionner une category pour l'article");
        }
        return errors;
    }

}
