package com.awainf.gestionstock.models;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "vente")
public class Vente extends EntityAbstract {

    @Column(name = "code")
    private String code;

    @Column(name = "datevente")
    private Instant dateVente;

    @Column(name = "commentaire")
    private String commentaire;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @OneToMany(mappedBy = "vente")
    private List<LigneVente> ligneVentes;

}
