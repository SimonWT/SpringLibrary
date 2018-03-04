package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.dao.ArticleDao;
import net.proselyte.springsecurityapp.dao.BookDao;
import net.proselyte.springsecurityapp.dao.RoleDao;
import net.proselyte.springsecurityapp.dao.UserDao;
import net.proselyte.springsecurityapp.model.Article;
import net.proselyte.springsecurityapp.model.Book;
import net.proselyte.springsecurityapp.model.Role;
import net.proselyte.springsecurityapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

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


}
