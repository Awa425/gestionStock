package com.awainf.gestionstock.dto;

import com.awainf.gestionstock.models.Adresse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdresseDto {

    private Integer id;

    private String adresse1;

    private String adresse2;

    private String ville;

    private String pays;

    private String codePostale;

    /* fromEntity qui permet de mapper une entite vers un DTO:: On va l'utiliser lors de la recuperation des donnees de la BDD (get) */
    public static AdresseDto fromEntity(Adresse adresse) {
        if (adresse == null) {
            return null;
            // TODO throw exception
        }

        return AdresseDto.builder()
                .adresse1(adresse.getAdresse1())
                .adresse2(adresse.getAdresse2())
                .ville(adresse.getVille())
                .pays(adresse.getPays())
                .codePostale(adresse.getCodePostale())
                .build();
    }

    /*  toEntity qui permet de mapper un DTO vers une entite:: On va l'utiliser lors de la creation / modification des donnees dans la BDD */
    public static Adresse toEntity(AdresseDto adresseDto) {
        if (adresseDto == null) {
            return null;
            // TODO throw exception
        }

        Adresse adresse = new Adresse();
        adresse.setAdresse1(adresseDto.getAdresse1());
        adresse.setAdresse2(adresseDto.getAdresse2());
        adresse.setVille(adresseDto.getVille());
        adresse.setPays(adresseDto.getPays());
        adresse.setCodePostale(adresseDto.getCodePostale());
        return adresse;
    }
}
