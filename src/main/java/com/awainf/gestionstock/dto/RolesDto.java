package com.awainf.gestionstock.dto;

import com.awainf.gestionstock.models.Roles;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolesDto {

    private Integer id;

    private String nom;

    private UsersDto user;

    /* Mapping Roles -> RolesDto */
    public static RolesDto fromeEntity(Roles roles) {
        if (roles == null) {
            return null;
            // TODO throw exception
        }

        return RolesDto.builder()
                .id(roles.getId())
                .nom(roles.getNom())
                .build();

    }

    /* Mapping RolerDto -> Roles */
    public static Roles toEntity(RolesDto rolesDto) {
        if (rolesDto == null) {
            return null;
            // TODO throw exception
        }

        Roles roles = new Roles();
        roles.setId(rolesDto.getId());
        roles.setNom(rolesDto.getNom());
        roles.setUser(UsersDto.toEntity(rolesDto.getUser()));
        return roles;
    }

}
