package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Users.Patron;
import net.proselyte.springsecurityapp.model.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO interface
 *
 * @author Igor Vakhula
 *
 */

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User getUserById(Long id);

    @Query("select u from Patron u")
    List<Patron> getAllPatron();



}
