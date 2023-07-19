package com.awainf.gestionstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awainf.gestionstock.models.LigneVente;

import java.util.List;

public interface LigneVenteRepository extends JpaRepository<LigneVente, Integer> {

    List<LigneVente> findAllByArticleId(Integer idArticle);

    List<LigneVente> findAllByVenteId(Integer id);

}
