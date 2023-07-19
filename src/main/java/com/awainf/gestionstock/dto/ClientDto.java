package com.awainf.gestionstock.dto;

import java.util.List;

import com.awainf.gestionstock.models.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDto {

    private Integer id;

    private String nom;

    private String prenom;

    private String telephone;

    private String mail;

    private String photo;

    private AdresseDto adresse;

    private Integer idEntreprise;

    @JsonIgnore
    private List<CommandeClientDto> commandeClients;

    /* Mapping Category -> CategoryDto */
    public static ClientDto fromEntity(Client client) {
        if (client == null) {
            return null;
            // TODO throw an exception
        }

        return ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .telephone(client.getTelephone())
                .mail(client.getMail())
                .photo(client.getPhoto())
                .idEntreprise(client.getIdEntreprise())
                .build();
    }

    /* Mapping CategoryDto -> Category */
    public static Client toEntity(ClientDto clientDto) {
        if (clientDto == null) {
            return null;
            // TODO throw exception
        }

        Client client = new Client();
        client.setId(clientDto.getId());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setTelephone(clientDto.getTelephone());
        client.setMail(clientDto.getMail());
        client.setPhoto(clientDto.getPhoto());
        client.setIdEntreprise(clientDto.getIdEntreprise());
        return client;

    }

}
