package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.model.User;

/**
 * Service class for {@link net.proselyte.springsecurityapp.model.User}
 *
 * @author Igor Vakhula
 */

public interface UserService {

    void save(User user);

    User findByUsername(String username);

    void delete(Long id);

    User getUserById(Long id);

    void update(User user);
}
