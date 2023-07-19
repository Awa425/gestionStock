package com.awainf.gestionstock.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.awainf.gestionstock.dto.CommandeClientDto;

public class CommandeClientValidator {

    public static List<String> validate(CommandeClientDto dto) {
        List<String> errors = new ArrayList<>();
        
        if (dto == null) {
            errors.add("Veuillez renseigner le code de la commande");
            errors.add("Veuillez renseigner la date de la commande");
            errors.add("Veuillez renseigner l'etat de la commande");
            errors.add("Veuillez renseigner le client");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getCode())) {
            errors.add("Veuillez renseigner le code du commande client");
        }

        if (dto.getDateCommande() == null) {
            errors.add("Veuillez renseigner la date");
        }

        if (!StringUtils.hasLength(dto.getEtatCommande().toString())) {
            errors.add("Veuillez renseigner l'etat du commande");

        }

        if (dto.getClient() == null || dto.getClient().getId() == null) {
            errors.add("Veuillez renseigner le client");
        }

        return errors;
    }

}
