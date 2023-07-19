package com.awainf.gestionstock.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.awainf.gestionstock.models.CommandeClient;
import com.awainf.gestionstock.models.CommandeFournisseur;

import java.util.Optional;
import java.util.List;

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer> {
    
    Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);

  List<CommandeClient> findAllByFournisseurId(Integer id);
}
