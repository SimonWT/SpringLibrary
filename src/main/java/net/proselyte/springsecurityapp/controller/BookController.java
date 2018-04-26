package net.proselyte.springsecurityapp.controller;

import net.proselyte.springsecurityapp.LogWriter;
import net.proselyte.springsecurityapp.model.Booking.History;
import net.proselyte.springsecurityapp.model.Booking.Queue;
import net.proselyte.springsecurityapp.model.Documents.Article;
import net.proselyte.springsecurityapp.model.Documents.AudioVideo;
import net.proselyte.springsecurityapp.model.Documents.Book;
import net.proselyte.springsecurityapp.model.Documents.Document;
import net.proselyte.springsecurityapp.model.Users.Patron;
import net.proselyte.springsecurityapp.model.Users.User;
import net.proselyte.springsecurityapp.service.*;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.util.calendar.BaseCalendar;

import javax.print.Doc;
import java.io.IOException;
import java.security.Principal;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;

import java.util.*;
import java.util.Date;

@Controller
public class BookController {
    final org.jboss.logging.Logger logger = LoggerFactory.logger(BookController.class);
    private final LogWriter log = new LogWriter();

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    private DocumentService docService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private QueueService queueService;

    private Long getCurrentUserId(){
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        return user.getId();
    }

    private User getCurrentUser(){
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        return user;
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public String addBook(Model model) {
        model.addAttribute("bookForm", new Book());
        return "addBook";

    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("bookForm") Book bookForm, BindingResult bindingResult, Model model) throws ParseException {
        //TODO: Book validation
        //bookValidator.validate(bookForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "addBook";
        }

        //userService.save(userForm);

        bookForm.parseDate();
        docService.save(bookForm);

        log.write(getCurrentUser(), "add", bookForm,null);

        /*
            this action authorizate new user after addition (it is useful in our case, but let it be here)
         */
        //securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/admin";
    }

    @RequestMapping(value = "/editBook/{id}", method = RequestMethod.GET)
    public String editInfo(@PathVariable("id") Long id , Model model) {
        Document doc = docService.getDocumentById(id);

        if(doc!=null) {
            logger.info("Book got by ID: " + doc.toString());
            java.util.Date date = ((Book) doc).getYear();
            String yearString = "";
            if (date != null) yearString = date.toString().substring(0, 10);
            ((Book) doc).setYearString(yearString);
        }

        model.addAttribute("bookForm", doc);
        return "editBook";
    }

    @RequestMapping(value = "/editBook/{id}",method = RequestMethod.POST)
    public String editInfo(@ModelAttribute("bookForm") Book bookForm, BindingResult bindingResult, Model model) throws ParseException {
        bookForm.parseDate();
        docService.update(bookForm);
        logger.info("Book updated: "+ bookForm.toString());
        log.write(getCurrentUser(), "edit", bookForm, null);
        return "redirect:/listOfBooks";
    }

    @RequestMapping(value = "/listOfBooksForPatron", method = RequestMethod.GET)
    public ModelAndView listOfBooksForPatron(Model model) {

        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        Long userId = user.getId();
        List<Book> bookList = docService.getListOfBook();

        for(Book book: bookList){
            Long bookId = book.getId();
            List<History> historyList= historyService.getListHistoriesByIdAndDocId(userId,bookId);


            int status = 1;
            if (historyList!=null && !historyList.isEmpty()){
                History userHistory = historyList.get(historyList.size()-1);
                status = userHistory.getStatus();
            }

//            if(status != 0 ){
//                if(book.getCopies() == 0) status = 2; //Go to Queue
//                else status = 3;                      //Simple CheckOut
//            }                                         //else Renew + Return

            if(book.getCopies() == 0 && (status!=0 && status!=2 && status!=3)) status = 4;

            book.setStatus(status);
            book.setYearString(DateToString(book.getYear(),0,4));
        }

      model.addAttribute(bookList);
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
        mav.setViewName("listOfBooksForPatron");

        mav.addObject("user", userData);

        return mav;
    }

    @RequestMapping(value = "/listOfBooks",method = RequestMethod.GET)
    public ModelAndView listOfBooks(Model model){
            List<Book> bookList = docService.getListOfBook();
            model.addAttribute(bookList);
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
        mav.setViewName("listOfBooks");

        mav.addObject("user", userData);

        return mav;
        }


    @RequestMapping(value = "/checkOutedBooks", method = RequestMethod.GET)
    public String checkOutedBooks(Principal principal, Model model) throws SQLException {
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        logger.info("ID: "+user.getId());
        Long idd = user.getId();

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1/deep_library_3rd_delivery");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        String query="SELECT books.* FROM user_books INNER JOIN books ON user_books.book_id = books.id WHERE user_books.user_id='"+idd+"'";
        Connection conn= DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(query);
        List<Book> list = new LinkedList<>();
        while(rs.next()){

                String title = rs.getString("title");
                String author = rs.getString("author");
                Integer price = rs.getInt("price");

                //Assuming you have a user object
                Book book = new Book();
                book.setAuthors(author);
                book.setTitle(title);
                book.setPrice(price);

                list.add(book);

        }


        model.addAttribute("listOfbooks", list );

        return "checkOutedBooks";
    }




    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        docService.delete(id);
        return "redirect:/listOfBooks";
    }

    @RequestMapping("/reg/Pat")
    public String regPat() throws IOException {
        User user = new Patron("TestInh","TestInh","TestInh","TestInh","TestInh","TestInh","TestInh", "testInh");
        ((Patron) user).setNotification("Check Notification");
        userService.save(user);

        User test = userService.findByUsername(user.getUsername());
        return "SUCCESS";
    }

    @RequestMapping("/test/addBook")
    public String testAddBook(){
        Book book = new Book(69,"SexLoveSlavs", 1488,"Yarik", "Innopolis", true, new Date(2017-1900, 0, 0) ,6 );
        docService.save(book);
        return "Success adding Book";
    }

    @RequestMapping("/test/addAV")
    public String testAddAV(){
        AudioVideo audioVideo = new AudioVideo(2, "KIdK", 166, "Yarik");
        docService.save(audioVideo);
        return "Success addong AV";
    }

    @RequestMapping("/test/addAtricle")
    public String testAddArticle(){
        Article article = new Article(2, "ART", 159, "Yarik", "Zhenya", new Date(System.currentTimeMillis()), "ELLO" );
        docService.save(article);
        return "Success adding Article";
    }

    @RequestMapping("/test/listBooks/")
    public String testListBooks(){
        List list = docService.getListOfBook();
        return "Success"+list.get(0).toString();
    }

    @RequestMapping("/test/checkOut/{id}")
    public String checkOut(@PathVariable("id") Long docId){
        Long userId = getCurrentUserId();
        Document document = docService.getDocumentById(docId);
        if (document.copies == 0) {
            Queue queue = new Queue(new Date(System.currentTimeMillis()), docId, userId);
            queueService.save(queue);
        } else {
            History history = new History(docId, userId, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 190000), 0, 0);
            historyService.save(history);
            document.copies--;
            docService.update(document);
        }
        return "Success";
    }




    @RequestMapping("/addnewdocument")
    public ModelAndView addNewDocument(){
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
        mav.setViewName("addnewdocument");

        mav.addObject("user", userData);

        return mav;

    }

    @RequestMapping("/test/getHistory/")
    public String getHistory(){
        System.out.println(historyService.getListOfHistoryByUser(Integer.toUnsignedLong(71)).get(0).getUserId());
        return "Success";
    }


    public java.util.Date parseDate(String year) throws ParseException {
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        java.util.Date date = format.parse(year);
        System.out.println(date); // 2010-01-02
        return date;
    }

    public String DateToString(java.util.Date date, int start, int finish){
        String yearString = "";
        if(date!=null) yearString = date.toString().substring(start,finish);
        return yearString;
    }
}

