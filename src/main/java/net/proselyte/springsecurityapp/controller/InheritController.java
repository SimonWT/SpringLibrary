package net.proselyte.springsecurityapp.controller;

import net.proselyte.springsecurityapp.model.Inherit.Librarians;
import net.proselyte.springsecurityapp.model.Inherit.Patrons;
import net.proselyte.springsecurityapp.model.Inherit.Users;
import net.proselyte.springsecurityapp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InheritController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/add/patron", method = RequestMethod.GET )
    public String addPatron(Model model){

        Patrons patrons = new Patrons("Keksik","Keksik","Keksik");

        usersService.save(patrons);
        return "SUKA.";
    }

    @RequestMapping(value = "/add/librarian", method = RequestMethod.GET )
    public String addLibrarian(Model model){

        Librarians librarians = new Librarians("Libra", "Libra", "Libra");
        usersService.save(librarians);
        return "BICHARA.";
    }

    @RequestMapping(value = "/get/patron", method = RequestMethod.GET)
    public String getPatron(Model model){
        return "GETS"+usersService.getUsersById(2);
    }
    @RequestMapping(value = "/get/libra", method = RequestMethod.GET)
    public String getLibrarian(Model model){
        return "GETS "+(usersService.getUsersById(1) instanceof Users);
    }
}
