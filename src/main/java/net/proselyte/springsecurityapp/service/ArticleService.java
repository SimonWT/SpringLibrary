package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.model.Documents.Article;

public interface ArticleService {

    void save(Article article);
    void delete(Long id);
    Article getArticleById(Long id);
    void update(Article article);
}
