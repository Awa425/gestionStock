package com.awainf.gestionstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awainf.gestionstock.models.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
