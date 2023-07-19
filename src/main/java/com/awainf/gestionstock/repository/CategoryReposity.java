package com.awainf.gestionstock.repository;

import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awainf.gestionstock.models.Categorie;

import java.util.Optional;

public interface CategoryReposity extends JpaRepository<Categorie, Integer> {

    Optional<Category> findCategoryByCode(String code);

}
