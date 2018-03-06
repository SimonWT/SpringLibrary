package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.model.Book;

public interface BookService {

    void save(Book book);
    void delete(Long id);
    Book getBookById(Long id);
    void update(Book book);

}
