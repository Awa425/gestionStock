package com.awainf.gestionstock.dto;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.awainf.gestionstock.models.Users;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsersDto {

    private Integer id;

    private String nom;

    private String prenom;

    private String telephone;

    private String mail;

    private String photo;

    private Instant dateDeNaissance;

    private String moteDePasse;

    private List<RolesDto> roles;

    private AdresseDto adresse;

    private EntrepriseDto entreprise;

    /* Mapping User -> UserDto */
    public static UsersDto fromEntity(Users users) {
        if (users == null) {
            return null;
            // TODO throw exception
        }

        return UsersDto.builder()
                .id(users.getId())
                .nom(users.getNom())
                .prenom(users.getPrenom())
                .mail(users.getMail())
                .moteDePasse(users.getMoteDePasse())
                .dateDeNaissance(users.getDateDeNaissance())
                .adresse(AdresseDto.fromEntity(users.getAdresse()))
                .photo(users.getPhoto())
                .entreprise(EntrepriseDto.fromEntity(users.getEntreprise()))
                .roles(
                        users.getRoles() != null ? users.getRoles().stream()
                                .map(RolesDto::fromeEntity)
                                .collect(Collectors.toList()) : null)
                .build();
    }

    /* Mapping UserDto -> User */

    public static Users toEntity(UsersDto usersDto) {
        if (usersDto == null) {
            return null;
            // TODO throw exception
        }

        Users user = new Users();
        user.setId(usersDto.getId());
        user.setNom(usersDto.getNom());
        user.setPrenom(usersDto.getPrenom());
        user.setMail(usersDto.getMail());
        user.setMoteDePasse(usersDto.getMoteDePasse());
        user.setDateDeNaissance(usersDto.getDateDeNaissance());
        user.setAdresse(AdresseDto.toEntity(usersDto.getAdresse()));
        user.setPhoto(usersDto.getPhoto());
        user.setEntreprise(EntrepriseDto.toEntity(usersDto.getEntreprise()));
        return user;
    }

}
