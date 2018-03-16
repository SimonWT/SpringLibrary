package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Inherit.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDao extends JpaRepository<Users, Integer> {
    Users getUsersById(int id);
}
