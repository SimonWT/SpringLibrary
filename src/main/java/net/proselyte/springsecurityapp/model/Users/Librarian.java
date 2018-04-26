package net.proselyte.springsecurityapp.model.Users;

import jdk.nashorn.internal.ir.annotations.Ignore;
import net.proselyte.springsecurityapp.LogWriter;
import net.proselyte.springsecurityapp.model.Booking.History;
import net.proselyte.springsecurityapp.model.Documents.Article;
import net.proselyte.springsecurityapp.model.Documents.AudioVideo;
import net.proselyte.springsecurityapp.model.Documents.Book;
import net.proselyte.springsecurityapp.model.Documents.Document;
import net.proselyte.springsecurityapp.model.Library.Library;
import net.proselyte.springsecurityapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * Created by evgeniy on 21.01.18.
 */

@Entity
@Component
@DiscriminatorValue("Librarian")
public class Librarian extends User {

    @Column(name = "privilege")
    private int privilege;

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

    @Autowired
    @Transient
    public HistoryServiceImpl historyService;

    @Transient
    @Autowired
    public QueueService queueService;

    @Transient
    private LogWriter log = new LogWriter();

    public void addPatron(Patron newPatron){
        if (privilege >= 2)
            userService.save(newPatron);
        else
            System.out.println("Permission denied");
    }

    public Librarian() {
        userService = new UserServiceImpl();
    }

    public Librarian(String username, String password, String name, String surname, String phone, String email, String type) {
        super(username, password, name, surname, phone, email, type);
    }

    public void addDoc(Document doc, int copiesAmount){
        if (privilege >= 2) {
            if (docService.getListOfArticle().contains(doc) || docService.getListOfAudioVideo().contains(doc) || docService.getListOfBook().contains(doc))
                doc.setCopies(doc.getCopies() + copiesAmount);
            else {
                doc.setCopies(copiesAmount);
                docService.save(doc);
            }
        }

        else{
            System.out.println("Permission denied");
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
        List<Document> docs = p.getDocuments();
        for (int i = 0; i < docs.size(); i++){
            long dif =  today.getTime() - p.getDocuments().get(i).getCheckoutDate().getTime();
            int difDays = (int) TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
            if (difDays > docs.get(i).getDue()){
                overdueDocuments.add(p.getDocuments().get(i));
                docs.get(i).setOverdue(difDays - p.getDocuments().get(i).getDue());
            }
        }
        return overdueDocuments;
    }

    public void removeDoc(Document doc, int copies){
        if (privilege == 3) {
            doc.setCopies(doc.getCopies() - copies);
            docService.update(doc);
            if (doc.getCopies() < 0)
                docService.delete(doc.getId());
        }
        else{
            System.out.println("Permission denied");
        }
    }

    public void removePatron(Patron p){
        if (privilege == 3)
            userService.delete(p.getId());
        else
            System.out.println("Permission denied");
    }

    public String checkInfo(Patron p){
//        if (!userService.getAllPatrons().contains(p)){
//            return "Information not available, patron does not exist.";
//        }
        StringBuilder info = new StringBuilder("Name: " + p.getName() + "\nAddress:" + p.getAddress() + "\nPhone:" + p.getPhone() + "\nId:" + p.getId() + /*"\nType:" + p.getType() +*/ "\nDocuments:\n");
        List<Document> docs = p.getDocuments();
        for (int i = 0; i < docs.size(); i++){
            info.append("\t Title: ").append(docs.get(i).getTitle()).append(" Due date: ").append(docs.get(i).getDueDate()).append("\n");
        }
        return info.toString();
    }

    public String checkOverdue(Patron p, Date d){
//        if (!userService.getAllPatrons().contains(p)){
//            return "Information not available, patron does not exist.";
//        }
        StringBuilder info = new StringBuilder("Name: " + p.getName() + "\nAddress:" + p.getAddress() + "\nPhone:" + p.getPhone() + "\nId:" + p.getId() + /*"\nType:" + p.getType() +*/ "\nDocuments:\n");
        List<Document> docs = p.getDocuments();
        for (int i = 0; i < docs.size(); i++){
            docs.get(i).setOverdue(d);
            info.append("\t Title: ").append(docs.get(i).getTitle()).append(" ").append(docs.get(i).getOverdue()).append(" days overdue ").append(docs.get(i).getFine()).append(" roubles fine\n");
        }
        return info.toString();
    }

    public void outstandingRequest(Document doc, Date curDate){
        if(this.privilege > 1) {
            Queue<Patron> queue = doc.queue;
            while (!queue.isEmpty()) {
                queue.poll().setNotification("You was removed from waiting list of document " + doc.getTitle());
            }

            List<Patron> patrons = userService.getAllPatrons();
            for (int i = 0; i < patrons.size(); i++) {
                History history = historyService.getHistoryByIdAndDocId(userService.findByUsername(patrons.get(i).getUsername()).getId(), doc.getId());
                if (history != null && history.status == 0) {
                    long dif = history.getReturnDate().getTime() - curDate.getTime();
                    int difDays = (int) TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
                    patrons.get(i).setNotification("You must return document " + doc.getTitle());
                    docService.getDocumentById(history.getDocId()).setDue(docService.getDocumentById(history.getDocId()).getDue() - difDays);
                    history.setReturnDate(curDate);
                    historyService.updateHistory(history);
                    userService.update(patrons.get(i));
                }
            }

            this.log.write(this, "placed an outstanding request on" , doc, null);

        }else this.log.writeAddition(this, "placed an outstanding request on" ,
                doc, null, "request was denied");


    }

    public long[] checkQueue(Document doc){
        long[] res = new long[doc.queue.size()];
        for (int i = 0; i < res.length; i++){
            res[i] = doc.queue.poll().getId();
        }
        return res;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    public String checkSysytem(){
        String res = String.valueOf((userService.getAllPatrons().size() + userService.getAllLibrarians().size())) + " users "
                + String.valueOf(docService.getAllDocuments().size()) + " documents";
        this.log.write(this, "checked system information", null, null);
        return res;
    }
}
