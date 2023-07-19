package com.awainf.gestionstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awainf.gestionstock.models.Vente;

public interface VenteRepository extends JpaRepository<Vente, Integer> {

}
