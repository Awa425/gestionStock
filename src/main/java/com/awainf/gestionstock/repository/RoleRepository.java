package com.awainf.gestionstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awainf.gestionstock.models.Roles;

public interface RoleRepository extends JpaRepository<Roles, Integer> {

}
