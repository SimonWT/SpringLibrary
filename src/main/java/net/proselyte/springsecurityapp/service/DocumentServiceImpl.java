package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.dao.DocDao;
import net.proselyte.springsecurityapp.model.Documents.Article;
import net.proselyte.springsecurityapp.model.Documents.AudioVideo;
import net.proselyte.springsecurityapp.model.Documents.Book;
import net.proselyte.springsecurityapp.model.Documents.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocDao docDao;

    @Override
    public void save(Document document) {
        docDao.save(document);
    }

    @Override
    public void delete(Long id) {
        docDao.delete(id);
    }

    @Override
    public Document getDocumentById(Long id) {
        return docDao.getDocumentById(id);
    }

    @Override
    public void update(Document document) {
        docDao.save(document);
    }

    @Override
    public List<Book> getListOfBook() {
        return docDao.getAllBooks();
    }

    @Override
    public List<AudioVideo> getListOfAudioVideo() {
        return docDao.getAllAudioVideos();
    }

    @Override
    public List<Article> getListOfArticle() {
        return docDao.getAllArticles();
    }

    @Override
    public List<Document> getAllDocuments() {
        return docDao.getAllByIdIsNotNull();
    }


}
