package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DAO interface
 *
 * @author Igor Vakhula
 *
 */
public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User getUserById(Long id);
}
