package net.proselyte.springsecurityapp.controller;

import net.proselyte.springsecurityapp.model.Booking.History;
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
import sun.util.calendar.BaseCalendar;

import javax.print.Doc;
import java.security.Principal;
import java.sql.*;
import java.time.Year;
import java.util.LinkedList;
import java.util.List;

@Controller
public class BookController {
    final org.jboss.logging.Logger logger = LoggerFactory.logger(BookController.class);

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

    public Long getCurrentUserId(){
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        return user.getId();
    }


    @RequestMapping(value = "/editBook/{id}", method = RequestMethod.GET)
    public String editInfo(@PathVariable("id") Long id , Model model) {
        Book book = bookService.getBookById(id);

        if(book!=null)
            logger.info("Book got by ID: "+book.toString());

        model.addAttribute("bookForm", book);

        return "editBook";
    }

    @RequestMapping(value = "/editBook/{id}",method = RequestMethod.POST)
    public String editInfo(@ModelAttribute("bookForm") Book bookForm, BindingResult bindingResult, Model model){
        bookService.update(bookForm);

        logger.info("Book updated: "+ bookForm.toString());
        return "redirect:/listOfBooks";
    }

    @RequestMapping(value = "/listOfBooksForPatron", method = RequestMethod.GET)
    public String listOfBooksForPatron() {
        return "listOfBooksForPatron";
    }

    @RequestMapping(value = "/checkOutedBooks", method = RequestMethod.GET)
    public String checkOutedBooks(Principal principal, Model model) throws SQLException {
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        logger.info("ID: "+user.getId());
        Long idd = user.getId();

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://eu-cdbr-west-02.cleardb.net:3306/heroku_f76d6fb9e659782");
        dataSource.setUsername("baff532465d8d9");
        dataSource.setPassword("ffa9cd9f");
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

    @RequestMapping("/bookingBook/{id}")
    public String bookBook(@PathVariable("id") Long id, Principal principal){
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(currentUser);
        Long user_id = user.getId();

        try{
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://eu-cdbr-west-02.cleardb.net:3306/heroku_f76d6fb9e659782");
            dataSource.setUsername("baff532465d8d9");
            dataSource.setPassword("ffa9cd9f");
            String query="INSERT INTO user_books VALUES ('"+user_id+",'"+id+"', '2018-03-07')";
            Connection conn= DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
            Statement stmt=conn.createStatement();
            stmt.executeQuery(query);
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return "welcome";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        bookService.delete(id);

        return "redirect:/listOfBooks";
    }

    @RequestMapping("/reg/Pat")
    public String regPat(){
        User user = new Patron("TestInh","TestInh","TestInh","TestInh","TestInh","TestInh","TestInh");
        userService.save(user);
        return "SUCCESS";
    }

    @RequestMapping("/test/addBook")
    public String testAddBook(){
        Book book = new Book(2,"F*cking Awesome", 89,"Yarik", "The Verge", true, new Date(2007-1900, 0, 0) ,2 );
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

        } else {
            History history = new History(docId, userId, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 190000), 0, 0);
            historyService.save(history);
            document.copies--;
            docService.update(document);
        }
        return "Success";
    }

    @RequestMapping("/test/getHistory/")
    public String getHistory(){
        System.out.println(historyService.getListOfHistoryByUser(Integer.toUnsignedLong(71)).get(0).getUserId());
        return "Success";
    }


}

