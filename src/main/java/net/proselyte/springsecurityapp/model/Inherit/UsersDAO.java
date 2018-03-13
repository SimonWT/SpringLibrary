package net.proselyte.springsecurityapp.model.Inherit;

import net.proselyte.springsecurityapp.model.Inherit.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDAO extends JpaRepository<Users, Long> {
    Users getUsersById(Long id);
}
