package net.proselyte.springsecurityapp.controller;

import net.proselyte.springsecurityapp.model.Book;
import net.proselyte.springsecurityapp.service.BookService;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
public class BookController {
    final org.jboss.logging.Logger logger = LoggerFactory.logger(BookController.class);

    @Autowired
    private BookService bookService;

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






    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        bookService.delete(id);

        return "redirect:/listOfBooks";
    }


}
