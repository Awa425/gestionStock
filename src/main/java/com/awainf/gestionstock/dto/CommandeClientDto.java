package com.awainf.gestionstock.dto;

import java.time.Instant;
import java.util.List;

import com.awainf.gestionstock.models.CommandeClient;
import com.awainf.gestionstock.models.EtatCommande;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeClientDto {

    private Integer id;

    private String code;

    private Instant dateCommande;

    private ClientDto client;

    private EtatCommande etatCommande;

    private Integer idEntreprise;

    private List<LigneCommandeClientDto> ligneCmdClts;

    /* Mapping Category -> CategoryDto */
    public static CommandeClientDto fromEntity(CommandeClient commandeClient) {
        if (commandeClient == null) {
            return null;
            // TODO throw an exception
        }

        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateCommande(commandeClient.getDateCommande())
                .idEntreprise(commandeClient.getIdEntreprise())
                .etatCommande(commandeClient.getEtatCommande())
                .client(ClientDto.fromEntity(commandeClient.getClient()))
                .build();
    }

    /* Mapping CategoryDto -> Category */
    public static CommandeClient toEntity(CommandeClientDto commandeClientDto) {
        if (commandeClientDto == null) {
            return null;
            // TODO throw exception
        }

        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(commandeClientDto.getId());
        commandeClient.setCode(commandeClientDto.getCode());
        commandeClient.setDateCommande(commandeClientDto.getDateCommande());
        commandeClient.setIdEntreprise(commandeClientDto.getIdEntreprise());
        commandeClient.setEtatCommande(commandeClientDto.getEtatCommande());
        commandeClient.setClient(ClientDto.toEntity(commandeClientDto.getClient()));
        return commandeClient;

    }

}
