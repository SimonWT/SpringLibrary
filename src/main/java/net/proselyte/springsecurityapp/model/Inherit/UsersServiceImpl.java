package net.proselyte.springsecurityapp.model.Inherit;

import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    private static UsersDAO usersDao;

    @Override
    public void save(Users user) {
        System.out.println("INHERIT!!!! "+user.getName());
        usersDao.save(user);
    }

    @Override
    public Users getUsersById(Long id) {
        return usersDao.getUsersById(id);
    }
}
