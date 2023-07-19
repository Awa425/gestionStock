package com.awainf.gestionstock.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.awainf.gestionstock.models.CommandeClient;

import java.util.Optional;
import java.util.List;


public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer>{

    Optional<CommandeClient> findCommandeClientByCode(String code);

    List<CommandeClient> findAllByClientId(Integer id);
}
