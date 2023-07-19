package com.awainf.gestionstock.dto;

import java.util.List;

import com.awainf.gestionstock.models.CommandeFournisseur;
import com.awainf.gestionstock.models.Fournisseur;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FournisseurDto {

    private Integer id;

    private String nom;

    private String prenom;

    private String telephone;

    private String mail;

    private String photo;

    private AdresseDto adresse;

    private Integer idEntreprise;

    @JsonIgnore
    private List<CommandeFournisseur> cmdFournisseurs;

    /* Mapping Fournisseur -> FournisseurDto */
    public static FournisseurDto fromEntity(Fournisseur fournisseur) {
        if (fournisseur == null) {
            return null;
        }

        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .nom(fournisseur.getNom())
                .prenom(fournisseur.getPrenom())
                .telephone(fournisseur.getTelephone())
                .mail(fournisseur.getMail())
                .photo(fournisseur.getPhoto())
                .idEntreprise(fournisseur.getIdEntreprise())
                .adresse(AdresseDto.fromEntity(fournisseur.getAdresse()))
                .build();
    }

    /* Mapping FournisseurDto -> Fournisseur */
    public static Fournisseur toEntity(FournisseurDto fournisseurDto) {
        if (fournisseurDto == null) {
            return null;
        }

        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(fournisseurDto.getId());
        fournisseur.setNom(fournisseurDto.getNom());
        fournisseur.setPrenom(fournisseurDto.getPrenom());
        fournisseur.setTelephone(fournisseurDto.getTelephone());
        fournisseur.setMail(fournisseurDto.getMail());
        fournisseur.setPhoto(fournisseurDto.getPhoto());
        fournisseur.setAdresse(AdresseDto.toEntity(fournisseurDto.getAdresse()));
        return fournisseur;

    }

}
