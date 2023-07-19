package com.awainf.gestionstock.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "category")
public class Categorie extends EntityAbstract {

    @Column(name = "designation")
    private String designation;

    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "category")
    private List<Article> Articles;

    @Column(name = "identreprise")
    private Integer idEntreprise;

}
