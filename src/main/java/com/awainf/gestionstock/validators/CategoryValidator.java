package com.awainf.gestionstock.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.awainf.gestionstock.dto.CategorieDto;

public class CategoryValidator {
    public static List<String> validate(CategorieDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null || !StringUtils.hasLength(dto.getCode())) {
            errors.add("Veuillez renseigner le code de la categorie");
        }

        return errors;
    }

}
