package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.dao.UsersDao;
import net.proselyte.springsecurityapp.model.Inherit.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public void save(Users users) {
        //System.out.println("INHERIT!!!! "+users.getName());
        usersDao.save(users);
    }

    @Override
    public Users getUsersById(int id) {
        return usersDao.getUsersById(id);
    }
}
