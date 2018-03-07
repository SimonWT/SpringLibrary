package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Article;
import net.proselyte.springsecurityapp.model.Book;
import net.proselyte.springsecurityapp.model.User;
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
