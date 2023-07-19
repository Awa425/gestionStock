package com.awainf.gestionstock.services.impl;

import java.util.List;
import java.util.Optional;
// import java.util.stream.Collector;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awainf.gestionstock.exception.EntityNotFoundException;
import com.awainf.gestionstock.exception.ErrorCode;
import com.awainf.gestionstock.dto.ArticleDto;
import com.awainf.gestionstock.exception.InvalidEntityException;
import com.awainf.gestionstock.models.Article;
import com.awainf.gestionstock.repository.ArticleRepository;
import com.awainf.gestionstock.services.ArticleService;
import com.awainf.gestionstock.validators.ArticleValidator;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll()
                .stream()
                /* Mapper l'objet provenant dans la base en dto */
                .map(ArticleDto::fromEntity)
                /* on le collect */
                .collect(Collectors.toList());
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if (codeArticle == null) {
            log.error("le code " + codeArticle + " de l'article  est null");
            return null;
        }
        // Recupere l'article dans la base
        Optional<Article> article = articleRepository.findByCodeArticle(codeArticle);

        /* mapping entity vers dto */
        ArticleDto dto = ArticleDto.fromEntity(article.get());

        /* on return l 'entité si trouver sinon on léve l'exception */
        return Optional.of(dto)
                .orElseThrow(
                        () -> new EntityNotFoundException("Aucun entité de l'id " + codeArticle + " n'a été trouvée",
                                ErrorCode.ARTICLE_NOT_FOUND));
    }

    @Override
    public ArticleDto findById(Integer id) {
        if (id == null) {
            log.error("id " + id + " est null");
            return null;
        }

        // Recupere l'article dans la base
        Optional<Article> article = articleRepository.findById(id);

        /* mapping entity vers dto */
        ArticleDto dto = ArticleDto.fromEntity(article.get());

        /* on return l 'enti té si trouver sinon on léve l'exception */
        return Optional.of(dto)
                .orElseThrow(() -> new EntityNotFoundException("Aucun entité de l'id " + id + " n'a été trouvée",
                        ErrorCode.ARTICLE_NOT_FOUND));

    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        List<String> errors = ArticleValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("L'article n'est pas valide", ErrorCode.ARTICLE_NOT_VALID, errors);
        }

        Article saveArticle = articleRepository.save(ArticleDto.toEntity(dto));

        return ArticleDto.fromEntity(saveArticle);
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("id est null");
            return;
        }

        articleRepository.deleteById(id);
    }
}
