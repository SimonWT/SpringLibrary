package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Documents.Article;
import net.proselyte.springsecurityapp.model.Documents.AudioVideo;
import net.proselyte.springsecurityapp.model.Documents.Book;
import net.proselyte.springsecurityapp.model.Documents.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.AbstractMap;
import java.util.List;

public interface DocDao  extends JpaRepository<Document, Long> {
    Document getDocumentById(Long id);

    @Query("select u from Book u where id = id")
    Book getBookById(Long id);

    @Query("select u from Book u")
    List<Book> getAllBooks();

    @Query("select u from AudioVideo u")
    List<AudioVideo> getAllAudioVideos();

    @Query("select u from Article u")
    List<Article> getAllArticles();

}
