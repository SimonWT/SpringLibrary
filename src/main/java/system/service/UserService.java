package system.service;

import system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.repository.UserDAO;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;



}
