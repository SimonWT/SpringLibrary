package system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;
import system.model.User;
import system.service.UserService;

import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("")
    public @ResponseBody String test(){

        return "NU CHTO SUCHARA";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView auth(){

        ModelAndView modelAndView= new ModelAndView();
        modelAndView.addObject("userFromServer", new User());
        modelAndView.setViewName("user_check_page");
        return modelAndView;
    }


    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public @ResponseBody String authReply(@ModelAttribute("userFromServer") User user){
        return ("/index/");
    }



}
