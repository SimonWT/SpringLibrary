package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Book;
import net.proselyte.springsecurityapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DAO interface
 *
 * @author Igor Vakhula
 *
 */
public interface BookDao extends JpaRepository<Book, Long> {
      Book getBookById(Long id);
   }
