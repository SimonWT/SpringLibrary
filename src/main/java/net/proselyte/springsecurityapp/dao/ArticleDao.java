package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Documents.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DAO interface
 *
 * @author Igor Vakhula
 *
 */
public interface ArticleDao extends JpaRepository<Article, Long> {
    Article getArticleById(Long id);
}
