package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.model.Documents.Article;
import net.proselyte.springsecurityapp.model.Documents.AudioVideo;
import net.proselyte.springsecurityapp.model.Documents.Book;
import net.proselyte.springsecurityapp.model.Documents.Document;

import java.util.List;

public interface DocumentService {

    void save(Document document);
    void delete(Long id);
    Document getDocumentById(Long id);
    Document getDocumentByTitle(String title);
    void update(Document document);
    List<Book> getListOfBook();
    List<AudioVideo> getListOfAudioVideo();
    List<Article> getListOfArticle();
    List<Document> getAllDocuments();

}
