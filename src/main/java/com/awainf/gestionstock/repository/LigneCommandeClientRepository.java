package com.awainf.gestionstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awainf.gestionstock.models.LigneCommandeClient;

import java.util.List;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient, Integer> {

    List<LigneCommandeClient> findAllByCommandeClientId(Integer id);

  List<LigneCommandeClient> findAllByArticleId(Integer id);
}
