package net.proselyte.springsecurityapp.controller;

import net.proselyte.springsecurityapp.model.Documents.Book;
import net.proselyte.springsecurityapp.model.Users.User;
import net.proselyte.springsecurityapp.service.BookService;
import net.proselyte.springsecurityapp.service.UserService;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Controller
public class BookController {
    final org.jboss.logging.Logger logger = LoggerFactory.logger(BookController.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

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
                book.setAuthor(author);
                book.setTitle(title);
                book.setPrice(price);

                list.add(book);

        }


        model.addAttribute("listOfbooks", list );

        return "checkOutedBooks";
    }



    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        bookService.delete(id);

        return "redirect:/listOfBooks";
    }


}
