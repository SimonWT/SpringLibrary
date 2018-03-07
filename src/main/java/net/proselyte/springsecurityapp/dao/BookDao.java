package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Book;
import net.proselyte.springsecurityapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * DAO interface
 *
 * @author Igor Vakhula
 *
 */
public interface BookDao extends JpaRepository<Book, Long> {

    Book getBookById(Long id);



   }
