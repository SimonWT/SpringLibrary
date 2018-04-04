package net.proselyte.springsecurityapp.model.Users;

import jdk.nashorn.internal.ir.annotations.Ignore;
import net.proselyte.springsecurityapp.dao.ForTesting.DocDao;
import net.proselyte.springsecurityapp.dao.ForTesting.DocDaoImpl;
import net.proselyte.springsecurityapp.model.Documents.Article;
import net.proselyte.springsecurityapp.model.Documents.AudioVideo;
import net.proselyte.springsecurityapp.model.Documents.Book;
import net.proselyte.springsecurityapp.model.Documents.Document;
import net.proselyte.springsecurityapp.model.Library.Library;
import net.proselyte.springsecurityapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by evgeniy on 21.01.18.
 */

@Entity
@Component
@DiscriminatorValue("Librarian")
public class Librarian extends User {

    @Transient
    @Autowired
    public UserService userService;

    @Autowired
    @Transient
    public ArticleServiceImpl articleService;

    @Autowired
    @Transient
    public BookServiceImpl bookService;

    @Autowired
    @Transient
    public AudioVideoMaterialServiceImpl avService;

    @Autowired
    @Transient
    public DocumentServiceImpl docService;

    public void addPatron(Patron newPatron){
        userService.save(newPatron);
    }

    public Librarian() {
        userService = new UserServiceImpl();
    }

    public Librarian(String username, String password, String name, String surname, String phone, String email, String type) {
        super(username, password, name, surname, phone, email, type);
    }

    public void addDoc(Document doc, int copiesAmount){
        if (docService.getListOfArticle().contains(doc) || docService.getListOfAudioVideo().contains(doc) || docService.getListOfBook().contains(doc))
            doc.setCopies(doc.getCopies() + copiesAmount);
        else {
            doc.setCopies(copiesAmount);
            docService.save(doc);
        }

    }

    public void modify(Document doc){
        //new attributes for documents get from the input window on site
        int price = 0;
        String authors = null, title = null, keys = null;
        doc.setDoc(title, price, authors, keys);
    }

    public ArrayList<Document> overdueDocuments(Patron p, Date today) {
        ArrayList<Document> overdueDocuments = new ArrayList<>();
        for (int i = 0; i < p.getDocuments().size(); i++){
            long dif =  today.getTime() - p.getDocuments().get(i).getCheckoutDate().getTime();
            int difDays = (int) TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
            if (difDays > p.getDocuments().get(i).getDue()){
                overdueDocuments.add(p.getDocuments().get(i));
                p.getDocuments().get(i).setOverdue(difDays - p.getDocuments().get(i).getDue());
            }
        }
        return overdueDocuments;
    }

    public void removeDoc(Document doc, int copies){
        //get list of documents
        doc.setCopies(doc.getCopies() - copies);
        docService.update(doc);
        if (doc.getCopies() < 0)
            docService.delete(doc.getId());
        //rewrite list of documents
    }

    public void removePatron(Patron p){
        userService.delete(p.getId());
    }

    public String checkInfo(Patron p){
        if (!userService.getAllPatrons().contains(p)){
            return "Information not available, patron does not exist.";
        }
        StringBuilder info = new StringBuilder("Name: " + p.getName() + "\nAddress:" + p.getAddress() + "\nPhone:" + p.getPhone() + "\nId:" + p.getId() + /*"\nType:" + p.getType() +*/ "\nDocuments:\n");
        List<Document> docs = p.getDocuments();
        for (int i = 0; i < docs.size(); i++){
            info.append("\t Title: ").append(docs.get(i).getTitle()).append(" Due date: ").append(docs.get(i).getDueDate()).append("\n");
        }
        return info.toString();
    }

    public String checkOverdue(Patron p, Date d){
        if (!userService.getAllPatrons().contains(p)){
            return "Information not available, patron does not exist.";
        }
        StringBuilder info = new StringBuilder("Name: " + p.getName() + "\nAddress:" + p.getAddress() + "\nPhone:" + p.getPhone() + "\nId:" + p.getId() + /*"\nType:" + p.getType() +*/ "\nDocuments:\n");
        List<Document> docs = p.getDocuments();
        for (int i = 0; i < docs.size(); i++){
            info.append("\t Title: ").append(docs.get(i).getTitle()).append(docs.get(i).getOverdue()).append(" days overdue").append(docs.get(i).getFine()).append(" roubles fine\n");
        }
        return info.toString();
    }

    public void emptyQueues(){
//        for (int i = 0; i < library.documents.size(); i++){
//            if (library.documents.get(i).queue.size() != 0){
//                library.documents.get(i).queue.clear();
//            }
//        }
    }
}
