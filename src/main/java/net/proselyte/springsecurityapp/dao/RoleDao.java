package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Documents.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DAO interface
 *
 * @author Igor Vakhula
 */
public interface RoleDao extends JpaRepository<Role, Long> {
}
