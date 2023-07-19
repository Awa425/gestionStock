package com.awainf.gestionstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awainf.gestionstock.models.MouvementStock;

public interface MouvementStockRepository extends JpaRepository<MouvementStock, Integer>{

}
