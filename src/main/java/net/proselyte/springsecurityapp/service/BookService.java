package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.model.Documents.Book;

import java.util.List;

public interface BookService {

    void save(Book book);
    void delete(Long id);
    Book getBookById(Long id);
    void update(Book book);
    List<Book> checkOutBooksByUserId(Long id);

}
