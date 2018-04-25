package net.proselyte.springsecurityapp.controller;

import javafx.animation.ParallelTransition;
import net.proselyte.springsecurityapp.LogWriter;
import net.proselyte.springsecurityapp.model.Booking.History;
import net.proselyte.springsecurityapp.model.Booking.Queue;
import net.proselyte.springsecurityapp.model.Documents.Article;
import net.proselyte.springsecurityapp.model.Documents.AudioVideo;
import net.proselyte.springsecurityapp.model.Documents.Book;
import net.proselyte.springsecurityapp.model.Documents.Document;
import net.proselyte.springsecurityapp.model.Library.Library;
import net.proselyte.springsecurityapp.model.Users.*;
import net.proselyte.springsecurityapp.service.*;
import net.proselyte.springsecurityapp.validator.ArticleValidator;
import net.proselyte.springsecurityapp.validator.AudioVideoValidator;
import net.proselyte.springsecurityapp.validator.BookValidator;
import net.proselyte.springsecurityapp.validator.UserValidator;
import org.hibernate.Query;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.MailException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.log.LogHandler;


import java.io.IOException;
import java.security.Principal;
import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Controller for {@link User}'s pages.
 *
 * @author Igor Vakhula
 */


@SuppressWarnings("ALL")
@Controller
public class UserController {
    private final Logger logger = LoggerFactory.logger(UserController.class);
    private final LogWriter log = new LogWriter();

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

    @Autowired
    private QueueService queueService;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private NotificationService notificationService;

    public UserController() throws IOException {
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id){

        log.write(getCurrentUser(), "delete", null, userService.getUserById(id));
        userService.delete(id);

        return "redirect:/listOfUsers";
    }

    private Long getCurrentUserId(){
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        Long userId = user.getId();
        return userId;
    }

    private User getCurrentUser(){
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        return user;
    }



    public User selecType(User user){
        User newUser = new Patron();
        if(user.getTypeString().equals("Librarian")) newUser = new Librarian(user.getUsername(), user.getPassword(),user.getName(), user.getSurname(), user.getPhone(), user.getEmail(), "Librarian");
        else if (user.getTypeString().equals("Student")) newUser = new Student(user.getUsername(), user.getPassword(),user.getName(), user.getSurname(), user.getPhone(), user.getEmail(), "Student", "Lenina");
        else if (user.getTypeString().equals("TA")) newUser = new TA(user.getUsername(), user.getPassword(),user.getName(), user.getSurname(), user.getPhone(), user.getEmail(), "TA", "Lenina");
        else if (user.getTypeString().equals("Instructor")) newUser = new Instructor(user.getUsername(), user.getPassword(),user.getName(), user.getSurname(), user.getPhone(), user.getEmail(), "Instructor", "Lenina");
        else if (user.getTypeString().equals("Professor")) newUser = new Professor(user.getUsername(), user.getPassword(),user.getName(), user.getSurname(), user.getPhone(), user.getEmail(), "Professor", "Lenina");
        else if (user.getTypeString().equals("Visiting Professor")) newUser = new VisitingProfessor(user.getUsername(), user.getPassword(),user.getName(), user.getSurname(), user.getPhone(), user.getEmail(), "Visiting Professor", "Lenina");
        return newUser;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration(Model model) {
        model.addAttribute("userForm", new User());
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        ModelAndView mav = new ModelAndView();

        Map<String, String> userData = new HashMap<>();
        userData.put("username", user.getUsername());
        userData.put("name", user.getName());
        userData.put("surname", user.getSurname());
        userData.put("phone", user.getPhone());
        userData.put("email", user.getEmail());
        userData.put("type", user.getType());
        mav.setViewName("registration");

        mav.addObject("user", userData);

        return mav;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User user, BindingResult bindingResult, Model model) throws IOException {
        //userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(selecType(user));
        //send a notification
        try {
            notificationService.sendNotification(user);
        } catch (MailException e) {
            //catch error
            logger.info("Error Sending Email:" + e.getMessage());
        }

        /*
            this action authorizate new user after addition (it is useful in our case, but let it be here)
         */
        //securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        log.write(getCurrentUser(), "add new" , null,
                userService.findByUsername(user.getUsername()));

        return "redirect:/admin";
    }

    @RequestMapping(value = "/registerLibrarian", method = RequestMethod.GET)
    public ModelAndView registrationOfLibrarian(Model model) {
        model.addAttribute("userForm", new Librarian());
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        ModelAndView mav = new ModelAndView();

        Map<String, String> userData = new HashMap<>();
        userData.put("username", user.getUsername());
        userData.put("name", user.getName());
        userData.put("surname", user.getSurname());
        userData.put("phone", user.getPhone());
        userData.put("email", user.getEmail());
        userData.put("type", user.getType());

        mav.setViewName("registerLibrarian");
        mav.addObject("user", userData);

        return mav;
    }

    @RequestMapping(value = "/registerLibrarian", method = RequestMethod.POST)
    public String registrationOfLibrarian(@ModelAttribute("userForm") Librarian user, BindingResult bindingResult, Model model) throws IOException {
        //userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        //userService.save((Librarian)user);
        user.setType("Librarian");
        userService.save(user);


        //send a notification
        try {
            notificationService.sendNotification(user);
        } catch (MailException e) {
            //catch error
            logger.info("Error Sending Email:" + e.getMessage());
        }

        /*
            this action authorizate new user after addition (it is useful in our case, but let it be here)
         */
        //securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());
        log.write(getCurrentUser(), "register" , null, user);

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
    public ModelAndView listOfUsers(Model model) {

        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        ModelAndView mav = new ModelAndView();

        model.addAttribute("listUser", userService.getAllPatrons());

        Map<String, String> userData = new HashMap<>();
        userData.put("username", user.getUsername());
        userData.put("name", user.getName());
        userData.put("surname", user.getSurname());
        userData.put("phone", user.getPhone());
        userData.put("email", user.getEmail());
        userData.put("type", user.getType());
        mav.setViewName("listOfUsers");

        mav.addObject("user", userData);

        return mav;
    }

    @RequestMapping(value = "/listOfLibrarians", method = RequestMethod.GET)
    public ModelAndView listOfLibrarians(Model model) {

        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        ModelAndView mav = new ModelAndView();

        List<Librarian> librarianList = userService.getAllLibrarians();

        model.addAttribute("librarianList", librarianList);

        Map<String, String> userData = new HashMap<>();
        userData.put("username", user.getUsername());
        userData.put("name", user.getName());
        userData.put("surname", user.getSurname());
        userData.put("phone", user.getPhone());
        userData.put("email", user.getEmail());
        userData.put("type", user.getType());

        mav.setViewName("listOfLibrarians");

        mav.addObject("user", userData);

        return mav;
    }

    @RequestMapping(value="/editUser/{id}", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable("id") Long id, Model model) throws IOException {
        User user1 = userService.getUserById(id);

        if(user1!=null)
            logger.info("Users got by ID: " + user1.toString());

        model.addAttribute("userForm", user1);
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        ModelAndView mav = new ModelAndView();

        Map<String, String> userData = new HashMap<>();
        userData.put("username", user.getUsername());
        userData.put("name", user.getName());
        userData.put("surname", user.getSurname());
        userData.put("phone", user.getPhone());
        userData.put("email", user.getEmail());
        userData.put("type", user.getType());
        mav.setViewName("editUser");

        mav.addObject("user", userData);


        return mav;
    }

    @RequestMapping(value = "/editUser/{id}",method = RequestMethod.POST)
    public String editUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) throws IOException {
        userService.delete(userService.findByUsername(userForm.getUsername()).getId());
        userService.update(selecType(userForm));

        logger.info("Users updated: "+ userForm.toString());
        log.write(getCurrentUser(), "edit" , null,
                userService.findByUsername(userForm.getUsername()));

        return "redirect:/listOfUsers";
    }

    @RequestMapping(value="/editLibrarian/{id}", method = RequestMethod.GET)
    public ModelAndView editLibrarian(@PathVariable("id") Long id, Model model) {
        User user1 = userService.getUserById(id);

        if (user1 != null)
            logger.info("Users got by ID: " + user1.toString());

        user1 = (Librarian) user1;

        model.addAttribute("userForm", user1);
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        ModelAndView mav = new ModelAndView();

        Map<String, String> userData = new HashMap<>();
        userData.put("username", user.getUsername());
        userData.put("name", user.getName());
        userData.put("surname", user.getSurname());
        userData.put("phone", user.getPhone());
        userData.put("email", user.getEmail());
        userData.put("type", user.getType());

        mav.setViewName("editLibrarian");

        mav.addObject("user", userData);

        return mav;
    }

    @RequestMapping(value = "/editLibrarian/{id}",method = RequestMethod.POST)
    public String editLibrarian(@ModelAttribute("userForm") Librarian userForm, BindingResult bindingResult, Model model) throws IOException {

       // userService.delete(userService.findByUsername(userForm.getUsername()).getId());
        userService.delete(userForm.getId());
        userService.update(userForm);
        userForm.setType(userForm.getTypeString());

        logger.info("Users updated: "+ userForm.toString());

        log.write(getCurrentUser(), "edit" , null,
                userForm);

        return "redirect:/listOfUsers";

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


    @RequestMapping(value = "/mydoc", method = RequestMethod.GET)
    public ModelAndView history(Model model){
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        Long userId = user.getId();
        List<History> openHistories = new LinkedList<>();
        List<History> closeHistories = new LinkedList<>();
        List<History> historyList = historyService.getListOfHistoryByUser(userId);

       // List<Queue> queueList = queueService.getListOfQueueByUser(userId);
        List<Queue> queueList = null; // Не работает верхняя строка

        if(historyList !=null && historyList.size()>0 ) {

            for (int j =historyList.size()-1; j>=0; j--) {
                History history = historyList.get(j);
                Document document = documentService.getDocumentById(history.getDocId());

                int status = history.getStatus();
                if(status == 0 || status == 2 || status == 3){
                    openHistories.add(history);
                    document.setStatus(status);
                    history.setDocument(document);
                }

                else{
                    //Calculate Fine
                    if (100 * (history.getPenaltyDays()) < document.getPrice()) {
                        document.setFine(100 * (history.getPenaltyDays()));
                    }else
                        document.setFine(document.getPrice());

                    document.setStatus(status);
                    history.setDocument(document);
                    closeHistories.add(history);

                    //history.setFine();

                }

//                document.setStatus(status);
//                history.setDocument(document);

            }

        }

        if(queueList != null){
            for(Queue queue: queueList){
                Document document = documentService.getDocumentById(queue.docId);
                queue.setDocument(document);
            }
        }

        model.addAttribute(historyList);
        model.addAttribute("openHistories",openHistories);
        model.addAttribute("closeHistories",closeHistories);
        ModelAndView mav = new ModelAndView();

        Map<String, String> userData = new HashMap<>();
        userData.put("username", user.getUsername());
        userData.put("name", user.getName());
        userData.put("surname", user.getSurname());
        userData.put("phone", user.getPhone());
        userData.put("email", user.getEmail());
        userData.put("type", user.getType());
        mav.setViewName("mydoc");

        mav.addObject("user", userData);

        return mav;
    }

    @RequestMapping(value = "/booking/{docId}")
    public String booking(@PathVariable Long docId, Model model) throws IOException {
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        Document document = documentService.getDocumentById(docId);
        Long userId = user.getId();

        if(document==null) return "redirect:/error/wrongid";
        int status = -2;
        if(user instanceof Patron){
            Library library = new Library();
            library.patrons.add((Patron) user);
            // ((Patron) user).setLibrary(library);
            ((Patron) user).setDocumentService(documentService);
            ((Patron) user).setHistoryService(historyService);
            ((Patron) user).setUserService(userService);
             status = ((Patron) user).checkout(document, new Date(System.currentTimeMillis()));

        }else return "redirect:/error";
        //Status ==0 - Success

        try {
            notificationService.sendNotificationBooking(user, document);
        } catch (MailException e) {
            //catch error
            logger.info("Error Sending Email:" + e.getMessage());
        }

        return "redirect:/status/booking/"+docId;
    }

    @RequestMapping(value = "/queue/{docId}")
    public String queue(@PathVariable Long docId) throws IOException {
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        Long userId = user.getId();
        if(documentService.getDocumentById(docId)==null) return "redirect:/error/wrongid";
        int status = -2;
        if(user instanceof Patron){
            Library library = new Library();
            library.patrons.add((Patron) user);
            ((Patron) user).setQueueService(queueService);
            Queue queue = new Queue(new Date(System.currentTimeMillis()), docId, userId);
            queueService.save(queue);
            log.write(getCurrentUser(), " added to queue " , documentService.getDocumentById(docId),
                    null);
        }

        //Status ==0 - Success

        return "redirect:/listOfBooksForPatron";
    }


    @RequestMapping(value = "/return/{docId}")
    public String returnDoc(@PathVariable Long docId, Model model) throws IOException {
        try {
            String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userService.findByUsername(currentUser);
            Long userId = user.getId();
            if (documentService.getDocumentById(docId) == null) return "redirect:/error/wrongid";

            int status = -2;
            if (user instanceof Patron) {
                ((Patron) user).setDocumentService(documentService);
                ((Patron) user).setHistoryService(historyService);
                ((Patron) user).setUserService(userService);
                status = ((Patron) user).toReturn(documentService.getDocumentById(docId), new Date(System.currentTimeMillis()));
            }

            List<History> historyList = historyService.getListHistoriesByIdAndDocId(userId, docId);
            History history = historyList.get(historyList.size() - 1);
            if (history == null || history.status == 0) return "error";
            else {
                model.addAttribute("history", history);
                model.addAttribute("document", documentService.getDocumentById(history.getDocId()));
            }
        }catch (NullPointerException e){
            return "error";
        }
                                                        //Status ==0 - Success
        return "status";
    }


    @RequestMapping("/renew/{docId}")
    public String renewDoc(@PathVariable Long docId, Model model) throws IOException {
        Long userId = getCurrentUserId();
        User user = userService.getUserById(userId);
        Document document = documentService.getDocumentById(docId);
        if(document==null) return "redirect:/error/wrongid";

        int status = -2;
        if(user instanceof Patron) {
            ((Patron) user).setDocumentService(documentService);
            ((Patron) user).setHistoryService(historyService);
            ((Patron) user).setUserService(userService);
            ((Patron) user).renew(document, new Date(System.currentTimeMillis()));
        }

        List<History> historyList= historyService.getListHistoriesByIdAndDocId(userId,docId);
        History history = historyList.get(historyList.size()-1);
        if(history == null || history.status==0) return "error";
        else{
            history.setDocument(document);
            model.addAttribute("history", history );
            //model.addAttribute("document", document);
        }
        return "status";
    }


    @RequestMapping("/test/listOfPatrons/")
    public String listOfPatrons(){
        String result="";
        List<Patron> patrons = userService.getAllPatrons();
        for (int i=0; i<patrons.size(); i++) result += patrons.get(i).toString();
        return result;
    }

    @RequestMapping(value = "/status/booking/{docId}", method = RequestMethod.GET)
    public String statusBooking(@PathVariable Long docId, Model model ){
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        Long userId = user.getId();

        List<History> historyList= historyService.getListHistoriesByIdAndDocId(userId,docId);
        History history = historyList.get(historyList.size()-1);
        if(history == null) return "error";
        else model.addAttribute("history",history);

        return "status";
    }
    
    @RequestMapping(value = "/queue", method = RequestMethod.GET)
    public ModelAndView queue(Model model) {

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

        mav.setViewName("queue");

        mav.addObject("user", userData);

        return mav;
    }

    @RequestMapping(value = "/Logs", method = RequestMethod.GET)
    public ModelAndView logs(Model model){

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

        mav.setViewName("Logs");

        mav.addObject("user", userData);


        model.addAttribute("logs",log.read());

        return mav;

    }



    @RequestMapping(value = "/search/{title}", method = RequestMethod.GET)
     public String search(@PathVariable String title, ModelMap model) throws SQLException {
               List<Document> documents = documentService.getAllDocuments();
              List<Document> documentsAnswerListByTitle = new ArrayList<>();
               List<Document> documentsAnswerListByAuthor = new ArrayList<>();
                List<Document> documentsAnswerListByAuthorAndTitle = new ArrayList<>();
                List<Document> documentsAnswerListByKeyWords = new ArrayList<>();
                for (int i = 0; i < documents.size(); i++) {
                        Document document = documents.get(i);
                        if (document.getTitle().equals(title)) {
                                documentsAnswerListByTitle.add(document);
                                documentsAnswerListByAuthorAndTitle.add(document);
                            }
                        if (document.getAuthors().equals(title)) {
                                documentsAnswerListByAuthor.add(document);
                                documentsAnswerListByAuthorAndTitle.add(document);
                            }

        }
              model.put("documentsAnswerListByTitle", documentsAnswerListByTitle);
                model.put("documentsAnswerListByAuthor", documentsAnswerListByAuthor);
                model.put("documentsAnswerListByAuthorAndTitle", documentsAnswerListByAuthorAndTitle);



                return "search";
    }

    @RequestMapping(value = "/searchPart/{title}", method = RequestMethod.GET)
    public String searchPart(@PathVariable String title, ModelMap model) throws SQLException {
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        logger.info("ID: "+user.getId());
        Long idd = user.getId();

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1/deep_library_3rd_delivery");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        String query1="SELECT * FROM documents WHERE title regexp '[[:<:]]"+ title +"[[:>:]]'";

        Connection conn= DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(query1);
        List<Document> documentsPartialTitle = new LinkedList<>();
        while(rs.next()){

            String titlePart = rs.getString("title");
            String authorPart = rs.getString("authors");
            Integer pricePart = rs.getInt("price");

            //Assuming you have a user object
            Document document = new Document();
            document.setAuthors(authorPart);
            document.setTitle(titlePart);
            document.setPrice(pricePart);

            documentsPartialTitle.add(document);
        }
    model.put("documentsPartialTitle", documentsPartialTitle);
        return "searchPart";
    }

}
