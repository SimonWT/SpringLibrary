package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.dao.RoleDao;
import net.proselyte.springsecurityapp.dao.UserDao;
import net.proselyte.springsecurityapp.model.Documents.Role;
import net.proselyte.springsecurityapp.model.Users.Admin;
import net.proselyte.springsecurityapp.model.Users.Librarian;
import net.proselyte.springsecurityapp.model.Users.Patron;
import net.proselyte.springsecurityapp.model.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Implementation of {@link UserService} interface.
 *
 * @author Igor Vakhula
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        if (user instanceof Admin) {
            roles.add(roleDao.getOne(2L));
        } else if (user instanceof Librarian){
            if (((Librarian) user).getPrivilege() == 1)
                roles.add(roleDao.getOne(3L));
            else if (((Librarian) user).getPrivilege() == 2)
                roles.add(roleDao.getOne(4L));
            else if (((Librarian) user).getPrivilege() == 3)
                roles.add(roleDao.getOne(5L));
        } else
            roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
        userDao.save(user);


    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void update(User user) {
        
        Set<Role> roles = new HashSet<>();
        if (user instanceof Admin) {
            roles.add(roleDao.getOne(2L));
        } else if (user instanceof Librarian){
            if (((Librarian) user).getPrivilege() == 1)
                roles.add(roleDao.getOne(3L));
            else if (((Librarian) user).getPrivilege() == 2)
                roles.add(roleDao.getOne(4L));
            else if (((Librarian) user).getPrivilege() == 3)
                roles.add(roleDao.getOne(5L));
        } else
            roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    public List<Patron> getAllPatrons() {
        return userDao.getAllPatron();
    }

    @Override
    public List<Librarian> getAllLibrarians() {
        return userDao.getAllLibrarian();
    }
}
