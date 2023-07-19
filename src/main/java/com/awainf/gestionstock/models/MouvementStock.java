package com.awainf.gestionstock.models;

import java.math.BigDecimal;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "mouvementStock")
public class MouvementStock extends EntityAbstract {

    private Instant dateMvt;

    private BigDecimal quantite;

    private Integer idEntreprise;

    @ManyToOne
    @JoinColumn(name = "idArticle")
    private Article article;

}
