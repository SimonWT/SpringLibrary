package net.proselyte.springsecurityapp.dao.ForTesting;

import net.proselyte.springsecurityapp.model.Users.User;

public interface UserDao {
    void addUser(User user);
    User getUserById(Long id);
}
