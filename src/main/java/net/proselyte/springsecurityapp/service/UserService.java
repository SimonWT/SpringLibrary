package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.model.Users.Patron;
import net.proselyte.springsecurityapp.model.Users.User;

import java.util.List;

/**
 * Service class for {@link User}
 *
 * @author Igor Vakhula
 */

public interface UserService {

    void save(User user);

    User findByUsername(String username);

    void delete(Long id);

    User getUserById(Long id);

    void update(User user);

    List<Patron> getAllPatrons();
}
