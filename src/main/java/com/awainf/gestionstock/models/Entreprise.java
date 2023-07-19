package com.awainf.gestionstock.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "entreprise")
public class Entreprise extends EntityAbstract {

   @Column(name = "nom")
  private String nom;

  @Column(name = "description")
  private String description;

  @Embedded
  private Adresse adresse;

  @Column(name = "codefiscal")
  private String codeFiscal;

  @Column(name = "photo")
  private String photo;

  @Column(name = "email")
  private String email;

  @Column(name = "numtel")
  private String numTel;

  @Column(name = "siteweb")
  private String steWeb;

    @OneToMany(mappedBy = "entreprise")
    private List<Users> users;

}
