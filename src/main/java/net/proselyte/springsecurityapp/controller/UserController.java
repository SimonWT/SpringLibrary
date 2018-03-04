package net.proselyte.springsecurityapp.controller;

import net.proselyte.springsecurityapp.model.Article;
import net.proselyte.springsecurityapp.model.AudioVideo;
import net.proselyte.springsecurityapp.model.Book;
import net.proselyte.springsecurityapp.model.User;
import net.proselyte.springsecurityapp.service.*;
import net.proselyte.springsecurityapp.validator.ArticleValidator;
import net.proselyte.springsecurityapp.validator.AudioVideoValidator;
import net.proselyte.springsecurityapp.validator.BookValidator;
import net.proselyte.springsecurityapp.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for {@link net.proselyte.springsecurityapp.model.User}'s pages.
 *
 * @author Igor Vakhula
 */

@SuppressWarnings("ALL")
@Controller
public class UserController {

    @Autowired
    private UserService userService;



    @Autowired
    private BookService bookService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private AudioVideoMaterialService audioVideoMaterialService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private BookValidator bookValidator;

    @Autowired
    private ArticleValidator articleValidator;

    @Autowired
    private AudioVideoValidator audioVideoValidator;

    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public String addBook(Model model) {
        model.addAttribute("bookForm", new Book());

        return "addBook";

    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("bookForm") Book bookForm, BindingResult bindingResult, Model model) {
        bookValidator.validate(bookForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "addBook";
        }

        //userService.save(userForm);
        bookService.save(bookForm);
        /*
            this action authorizate new user after addition (it is useful in our case, but let it be here)
         */
        //securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/admin";
    }

    @RequestMapping(value = "/addArticle", method = RequestMethod.GET)
    public String addArticle(Model model) {
        model.addAttribute("articleForm", new Article());

        return "addArticle";

    }

    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public String addArticle(@ModelAttribute("articleForm") Article articleForm, BindingResult bindingResult, Model model) {
        articleValidator.validate(articleForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "addArticle";
        }

        //userService.save(userForm);
        articleService.save(articleForm);
        /*
            this action authorizate new user after addition (it is useful in our case, but let it be here)
         */
        //securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/admin";
    }

    @RequestMapping(value = "/addAudioVideoMaterial", method = RequestMethod.GET)
    public String addAudioVideoMaterial(Model model) {
        model.addAttribute("audioVideoForm", new AudioVideo());

        return "addAudioVideoMaterial";

    }

    @RequestMapping(value = "/addAudioVideoMaterial", method = RequestMethod.POST)
    public String addAudioVideoMaterial(@ModelAttribute("addAudioVideoMaterial") AudioVideo audioVideoForm, BindingResult bindingResult, Model model) {
        audioVideoValidator.validate(audioVideoForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "addAudioVideoMaterial";
        }

        //userService.save(userForm);
        audioVideoMaterialService.save(audioVideoForm);
        /*
            this action authorizate new user after addition (it is useful in our case, but let it be here)
         */
        //securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/admin";
    }



    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);
        /*
            this action authorizate new user after addition (it is useful in our case, but let it be here)
         */
        //securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/admin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = "/loginNew", method = RequestMethod.GET)
    public String test(){
        return "loginNew";
    }

    @RequestMapping(value = "/listOfUsers", method = RequestMethod.GET)
    public String listOfUsers() {

        return "listOfUsers";
    }

    @RequestMapping(value = "/listOfBooks", method = RequestMethod.GET)
    public String listOfBooks() {

        return "listOfBooks";
    }
    @RequestMapping(value = "/listOfArticles", method = RequestMethod.GET)
    public String listOfArticles() {

        return "listOfArticles";
    }
    @RequestMapping(value = "/editBook/{title}", method = RequestMethod.GET)
    @ResponseBody
    public String editInfo(@PathVariable("title") String title) {

        return "editBook" + "wehsdjf";
    }

    @RequestMapping(value = "/listOfAudioVideoMaterial", method = RequestMethod.GET)
    public String listOfAudioVideoMaterial() {

        return "listOfAudioVideoMaterial";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }
}
