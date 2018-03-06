package net.proselyte.springsecurityapp.controller;

import net.proselyte.springsecurityapp.service.ArticleService;
import net.proselyte.springsecurityapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/editBook/{title}", method = RequestMethod.GET)
    @ResponseBody
    public String editInfo(@PathVariable("title") String title) {

        return "editBook: " + title;
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        bookService.delete(id);

        return "redirect:/listOfBooks";
    }





}
