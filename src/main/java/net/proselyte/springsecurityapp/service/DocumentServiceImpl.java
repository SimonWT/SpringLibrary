package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.dao.DocDao;
import net.proselyte.springsecurityapp.model.Documents.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
