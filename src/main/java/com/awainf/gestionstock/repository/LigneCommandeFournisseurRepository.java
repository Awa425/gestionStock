package com.awainf.gestionstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awainf.gestionstock.models.LigneCommandeFournisseur;

import java.util.List;

public interface LigneCommandeFournisseurRepository extends JpaRepository<LigneCommandeFournisseur, Integer> {
    
    List<LigneCommandeFournisseur> findAllByCommandeFournisseurId(Integer idCommande);

    List<LigneCommandeFournisseur> findAllByArticleId(Integer idCommande);
}
