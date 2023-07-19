package com.awainf.gestionstock.dto;

import java.time.Instant;
import java.util.List;

import com.awainf.gestionstock.models.CommandeFournisseur;
import com.awainf.gestionstock.models.EtatCommande;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeFournisseurDto {

    private Integer id;

    private String code;

    private Instant dateCommande;

    private Integer idEntreprise;

    private EtatCommande etatCommande;

    private FournisseurDto fournisseur;

    private List<LigneCommandeFournisseurDto> ligneCmdFournisseurs;

    // Mapping CommandeFournisseur -> CommandeFournisseurDto
    public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur) {
        if (commandeFournisseur == null) {
            return null;
            // TODO throw exception
        }

        return CommandeFournisseurDto.builder()
                .id(commandeFournisseur.getId())
                .code(commandeFournisseur.getCode())
                .dateCommande(commandeFournisseur.getDateCommande())
                .idEntreprise(commandeFournisseur.getIdEntreprise())
                .etatCommande(commandeFournisseur.getEtatCommande())
                .build();
    }

    // Mapping CommandeFournisseurDto -> CommandeFournisseur
    public static CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto) {
        if (commandeFournisseurDto == null) {
            return null;
            // TODO Throw exception
        }

        CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
        commandeFournisseur.setId(commandeFournisseurDto.getId());
        commandeFournisseur.setCode(commandeFournisseurDto.getCode());
        commandeFournisseur.setDateCommande(commandeFournisseurDto.getDateCommande());
        commandeFournisseur.setIdEntreprise(commandeFournisseurDto.getIdEntreprise());
        commandeFournisseur.setEtatCommande(commandeFournisseurDto.getEtatCommande());
        return commandeFournisseur;
    }

}
