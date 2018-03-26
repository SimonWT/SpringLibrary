package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Documents.Book;
import net.proselyte.springsecurityapp.model.Documents.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocDao extends JpaRepository<Document, Long> {
    Document getDocumentById(Long id);

}
