package com.awainf.gestionstock.dto;

import java.util.List;

import com.awainf.gestionstock.models.Entreprise;
import com.awainf.gestionstock.models.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntrepriseDto {

    private Integer id;

    private String nom;

    private String description;

    private AdresseDto adresse;

    private String codeFiscal;

    private String photo;

    private String email;

    private String numTel;

    private String steWeb;

    @JsonIgnore
    private List<Users> users;

    /* Mapping Entreprise -> EntrepriseDto */
    public static EntrepriseDto fromEntity(Entreprise entreprise) {
        if (entreprise == null) {
            return null;
            // TODO throw exception
        }

        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .description(entreprise.getDescription())
                .codeFiscal(entreprise.getCodeFiscal())
                .email(entreprise.getEmail())
                .photo(entreprise.getPhoto())
                .numTel(entreprise.getNumTel())
                .steWeb(entreprise.getSteWeb())
                .adresse(AdresseDto.fromEntity(entreprise.getAdresse()))
                .build();
    }

    /* Mapping EntrepriseDto -> Entreprise */

    public static Entreprise toEntity(EntrepriseDto entrepriseDto) {
        if (entrepriseDto == null) {
            return null;
            // TODO throw exception
        }

        Entreprise entreprise = new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setNom(entrepriseDto.getNom());
        entreprise.setDescription(entrepriseDto.getDescription());
        entreprise.setCodeFiscal(entrepriseDto.getCodeFiscal());
        entreprise.setEmail(entrepriseDto.getEmail());
        entreprise.setPhoto(entrepriseDto.getPhoto());
        entreprise.setSteWeb(entrepriseDto.getSteWeb());
        entreprise.setNumTel(entreprise.getNumTel());
        entreprise.setAdresse(AdresseDto.toEntity(entrepriseDto.getAdresse()));
        return entreprise;
    }

}
