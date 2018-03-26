package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.model.Documents.Document;

public interface DocumentService {
    void save(Document document);
    void delete(Long id);
    Document getDocumentById(Long id);
    void update(Document document);
}
