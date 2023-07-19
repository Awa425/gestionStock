package com.awainf.gestionstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awainf.gestionstock.models.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
