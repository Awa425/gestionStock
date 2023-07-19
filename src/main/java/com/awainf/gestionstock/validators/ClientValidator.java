package com.awainf.gestionstock.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.awainf.gestionstock.dto.ClientDto;

public class ClientValidator {

    public static List<String> validate(ClientDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner le champs nom");
            errors.add("Veuillez renseigner le champs prenom");
            errors.add("Veuillez renseigner le champs email");
            errors.add("Veuillez renseigner le champs numero telephone");
             errors.addAll(AdresseValidator.validate(null));
            return errors;
        }

        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("Veuillez renseigner le champs nom");
        }
        if (!StringUtils.hasLength(dto.getPrenom())) {
            errors.add("Veuillez renseigner le champs prenom");
        }
        if (!StringUtils.hasLength(dto.getMail())) {
            errors.add("Veuillez renseigner le champs email");
        }
        if (!StringUtils.hasLength(dto.getTelephone())) {
            errors.add("Veuillez renseigner le champs numero telephone");
        }
        errors.addAll(AdresseValidator.validate(dto.getAdresse()));

        return errors;

    }

}
