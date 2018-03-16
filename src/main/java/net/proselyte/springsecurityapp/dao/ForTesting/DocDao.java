package net.proselyte.springsecurityapp.dao.ForTesting;

import net.proselyte.springsecurityapp.model.Documents.AudioVideo;
import net.proselyte.springsecurityapp.model.Documents.Book;
import net.proselyte.springsecurityapp.model.Documents.Document;

import java.util.List;

public interface DocDao {
    void addAV(AudioVideo av);
    void addBook(Book book);
    List<Document> getDocuments();
    void deleteLastBook();
    void deleteLastAV();


}
