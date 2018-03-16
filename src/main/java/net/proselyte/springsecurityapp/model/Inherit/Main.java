package net.proselyte.springsecurityapp.model.Inherit;

import net.proselyte.springsecurityapp.service.UserService;
import net.proselyte.springsecurityapp.service.UserServiceImpl;
import net.proselyte.springsecurityapp.service.UsersService;
import net.proselyte.springsecurityapp.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Main {
    @Autowired
    private static UsersService usersService = new UsersServiceImpl();

    @Autowired
    private static UserService uService = new UserServiceImpl();

    public static void main(String[] args){
        //Patrons patron = new Patrons("KIK", "KIK", "KIK");
        //usersService.save(patron);
        //System.out.println(usersService.getUsersById(1));
        System.out.println(uService.getUserById((long) 1));
    }
}
