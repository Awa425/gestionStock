package com.awainf.gestionstock.dto;

import java.time.Instant;
import java.util.List;

import com.awainf.gestionstock.models.Vente;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VenteDto {

    private Integer id;

    private String code;

    private Instant dateVente;

    private String commentaire;

    private Integer idEntreprise;

    private List<LigneVenteDto> ligneVentes;

    /* Mapping Vente -> VenteDto */
    public static VenteDto fromEntity(Vente vente) {
        if (vente == null) {
            return null;
            // TO throw exception
        }

        return VenteDto.builder()
                .id(vente.getId())
                .code(vente.getCode())
                .commentaire(vente.getCommentaire())
                .idEntreprise(vente.getIdEntreprise())
                .build();
    }

    /* Mapping Vente -> VenteDto */
    public static Vente toEntity(VenteDto venteDto) {
        if (venteDto == null) {
            return null;
            // TO throw exception
        }

        Vente vente = new Vente();
        vente.setId(venteDto.getId());
        vente.setCode(venteDto.getCode());
        vente.setCommentaire(venteDto.getCommentaire());
        vente.setIdEntreprise(venteDto.getIdEntreprise());
        return vente;
    }

}
