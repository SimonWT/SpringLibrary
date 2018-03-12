package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.dao.BookDao;
import net.proselyte.springsecurityapp.model.Documents.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of {@link BookService} interface.
 *
 * @author Igor Vakhula
 */

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public void save(Book book) {
        bookDao.save(book);
    }

    @Override
    public void delete(Long id) {
        bookDao.delete(id);
    }

    @Override
    public Book getBookById(Long id) {
        return bookDao.getBookById(id);
    }

    @Override
    public void update(Book book) {
        bookDao.save(book);
    }

    @Override
    public List<Book> checkOutBooksByUserId(Long id) {
        return null;
    }


}
