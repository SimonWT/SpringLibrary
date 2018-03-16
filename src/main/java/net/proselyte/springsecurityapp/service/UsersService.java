package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.model.Inherit.Users;

public interface UsersService {
    void save(Users user);
    Users getUsersById(int id);
}
