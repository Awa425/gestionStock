package com.awainf.gestionstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awainf.gestionstock.models.Article;

import java.util.List;
import java.util.Optional;


public interface ArticleRepository extends JpaRepository<Article, Integer> {
  
    Optional<Article> findByCodeArticle(String codeArticle);

    List<Article> findAllByCategoryId(Integer idCategory);
}
