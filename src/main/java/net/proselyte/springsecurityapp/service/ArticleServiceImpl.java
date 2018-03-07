package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.dao.ArticleDao;
import net.proselyte.springsecurityapp.model.Documents.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link ArticleService} interface.
 *
 * @author Igor Vakhula
 */

@Service
public class ArticleServiceImpl implements ArticleService {



    @Autowired
    private ArticleDao articleDao;


    @Override
    public void save(Article article) {
        articleDao.save(article);
    }

    @Override
    public void delete(Long id) {
        articleDao.delete(id);
    }

    @Override
    public Article getArticleById(Long id) {
        return articleDao.getArticleById(id);
    }

    @Override
    public void update(Article article) {
        articleDao.save(article);
    }


}
