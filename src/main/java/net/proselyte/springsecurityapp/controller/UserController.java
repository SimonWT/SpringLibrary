package net.proselyte.springsecurityapp.controller;

import net.proselyte.springsecurityapp.model.Booking.History;
import net.proselyte.springsecurityapp.model.Documents.Article;
import net.proselyte.springsecurityapp.model.Documents.AudioVideo;
import net.proselyte.springsecurityapp.model.Documents.Book;
import net.proselyte.springsecurityapp.model.Documents.Document;
import net.proselyte.springsecurityapp.model.Users.Patron;
import net.proselyte.springsecurityapp.model.Users.User;
import net.proselyte.springsecurityapp.service.*;
import net.proselyte.springsecurityapp.validator.ArticleValidator;
import net.proselyte.springsecurityapp.validator.AudioVideoValidator;
import net.proselyte.springsecurityapp.validator.BookValidator;
import net.proselyte.springsecurityapp.validator.UserValidator;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller for {@link User}'s pages.
 *
 * @author Igor Vakhula
 */


@SuppressWarnings("ALL")
@Controller
public class UserController {
    private final Logger logger = LoggerFactory.logger(UserController.class);

    @Autowired
    private UserService userService;

    /*
    * INHERITANCE testing
     */
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

    @Autowired
    private HistoryService historyService;

    @RequestMapping(value = "/test/inh", method = RequestMethod.GET )
    public String testInh(Model model){



        return "SUKA.";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.delete(id);

        return "redirect:/listOfUsers";
    }

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
        //userValidator.validate(userForm, bindingResult);

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
    @RequestMapping(value = "/ProfilePage", method = RequestMethod.GET)
    public String ProfilePage(Model model) {
        model.addAttribute("userForm", new User());

        return "ProfilePage";
    }
    @RequestMapping(value = "/ProfilePage", method = RequestMethod.POST)
    public String ProfilePage (@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
          userValidator.validate(userForm, bindingResult);

          return "ProfilePage";

    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {

        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
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

    @RequestMapping(value="/editUser/{id}", method = RequestMethod.GET)
    public String editUser(@PathVariable("id") Long id, Model model){
        User user = userService.getUserById(id);

        if(user!=null)
            logger.info("Users got by ID: " + user.toString());

        model.addAttribute("userForm", user);

        return "editUser";
    }

    @RequestMapping(value = "/editUser/{id}",method = RequestMethod.POST)
    public String editUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model){
        userService.update(userForm);

        logger.info("Users updated: "+ userForm.toString());
        return "redirect:/listOfUsers";
    }

    @RequestMapping(value = "/listOfBooks", method = RequestMethod.GET)
    public String listOfBooks() {

        return "listOfBooks";
    }
    @RequestMapping(value = "/listOfArticles", method = RequestMethod.GET)
    public String listOfArticles() {

        return "listOfArticles";
    }

    @RequestMapping(value = "/listOfAudioVideoMaterial", method = RequestMethod.GET)
    public String listOfAudioVideoMaterial() {

        return "listOfAudioVideoMaterial";
    }

    @RequestMapping(value = "/testId", method = RequestMethod.GET)
    public String showResults(Principal principal) {
         String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
         User user = userService.findByUsername(currentUser);
         logger.info("ID: "+user.getId());

         return "/welcome";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public ModelAndView welcome(Model model) {
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        ModelAndView mav = new ModelAndView();
        /*Map<String, String> message1 = new HashMap<String, String>();
        message1.put("message1", "Hello World");
        mav.setViewName("welcome");
        mav.addObject("message", message1);*/
        Map<String, String> userData = new HashMap<>();
        userData.put("username", user.getUsername());
        userData.put("name", user.getName());
        userData.put("surname", user.getSurname());
        userData.put("phone", user.getPhone());
        userData.put("email", user.getEmail());
        userData.put("type", user.getType());
        mav.setViewName("welcome");

        mav.addObject("user", userData);

        return mav;

    }



    /*@RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public ModelAndView welcome(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        ModelAndView modelAndView = new ModelAndView();
        Map<String, String> userData = new HashMap<String, String>();
        userData.put("id", user.getId().toString());
        userData.put("username", user.getUsername());

        userData.put("name", user.getName());
        userData.put("surname", user.getName());
        userData.put("phone", user.getPhone());
        userData.put("email", user.getEmail());
        userData.put("type", user.getType());
        modelAndView.addAllObjects(userData);
        return modelAndView;
    }*/

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin(Model model) {

        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        ModelAndView mav = new ModelAndView();
        /*Map<String, String> message1 = new HashMap<String, String>();
        message1.put("message1", "Hello World");
        mav.setViewName("welcome");
        mav.addObject("message", message1);*/
        Map<String, String> userData = new HashMap<>();
        userData.put("username", user.getUsername());
        userData.put("name", user.getName());
        userData.put("surname", user.getSurname());
        userData.put("phone", user.getPhone());
        userData.put("email", user.getEmail());
        userData.put("type", user.getType());
        mav.setViewName("admin");

        mav.addObject("user", userData);

        return mav;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(Model model) { return "user"; }


    @RequestMapping(value = "/mydoc/", method = RequestMethod.GET)
    public String history(ModelAndView modelAndView){
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        Long userId = user.getId();
        List<History> historyList = historyService.getListOfHistoryByUser(userId);
        for(History history: historyList){
            Document document = history.getDocument();
            int status = history.getStatus();
            if(status != 0 ){
                if(document.getCopies() == 0) status = 2; //Go to Queue
                else status = 3;                      //Simple CheckOut
            }                                         //else Renew + Return
            document.setStatus(status);
            history.setDocument(document);
        }

        modelAndView.addObject(historyList);
        return  "/mydoc/";
    }

    @RequestMapping("/test/listOfPatrons/")
    public String listOfPatrons(){
        String result="";
        List<Patron> patrons = userService.getAllPatrons();
        for (int i=0; i<patrons.size(); i++) result += patrons.get(i).toString();
        return result;
    }




}