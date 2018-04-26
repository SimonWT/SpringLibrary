package net.proselyte.springsecurityapp.model.Users;

import net.proselyte.springsecurityapp.LogWriter;
import net.proselyte.springsecurityapp.model.Booking.History;
import net.proselyte.springsecurityapp.model.Booking.Queue;
import net.proselyte.springsecurityapp.model.Documents.Book;
import net.proselyte.springsecurityapp.model.Documents.Document;
import net.proselyte.springsecurityapp.model.Documents.Role;
import net.proselyte.springsecurityapp.model.Library.Library;
import net.proselyte.springsecurityapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.print.Doc;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by evgeniy on 21.01.18.
 */

@Entity
@DiscriminatorValue("Patron")
@Component
public class Patron extends User {


    @Column(name = "address")
    private String address;

    @Transient
    @Autowired
    private DocumentService documentService;

    @Transient
    @Autowired
    private HistoryService historyService;

//    @Transient
//    private ArrayList <Document> documents; //documents checked by this user

    @Transient
    @Autowired
    private UserService userService;

    @Transient
    @Autowired
    private QueueService queueService;

    @Transient
    private LogWriter log = new LogWriter();

    @Transient
    private String notification;



    public Patron(){};

    public Patron(String username, String password, String name, String surname, String phone, String email, String type, String address){
        super(username, password, name, surname, phone, email, type);
        this.address = address;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public QueueService getQueueService() { return queueService; }

    public void setQueueService(QueueService queueService) {
        this.queueService = queueService;
    }

    public int checkout(Document doc, Date checkoutDate){

        if (userService.getAllPatrons().contains(this)){
            System.out.println("You have not registered in system. Ask librarian to register you in system");
            return 1;
        }
        //TODO: Check branches, Copies of Doc -1
        Long id = userService.findByUsername(this.getUsername()).getId();
        List<History> historyList= historyService.getListHistoriesByIdAndDocId(this.getId(),doc.getId());
        History historyByIdAndDocId = null;
        if(historyList!=null && !historyList.isEmpty()) {
            historyByIdAndDocId = historyList.get(historyList.size() - 1);
         }

        if (historyByIdAndDocId!=null && historyByIdAndDocId.getStatus() == 0 ){
            System.out.println("user " + getName() + " already have this document");
            return 2;
        }
        if (documentService.getDocumentById(doc.getId()) != null && doc.getCopies() > 0) {
            Document checkedDoc = doc.toCopy();

//            History h = historyService.getHistoryByIdAndDocId(this.getId(), doc.getId());
//            h.status = 0;
//            historyService.updateHistory(h);

            //doc.setCopies(doc.getCopies()-1);
            documentService.update(doc);

            //doc.patron = this;
            //doc.resetDate();
            //doc.setCopies(doc.getCopies() - 1);


            if (!(doc instanceof Book)){
                checkedDoc.setDue(14);
            }
            else if (this instanceof Faculty){
                checkedDoc.setDue(28);
            } else{
                Book b = (Book) doc;
                if (((Book ) b).isBestSeller()){
                    checkedDoc.setDue(14);
                }
                else {
                    checkedDoc.setDue(21);
                }
            }
            if (this instanceof VisitingProfessor){
                checkedDoc.setDue(7);
            }
            checkedDoc.setCheckoutDate(checkoutDate);
            if (historyByIdAndDocId == null)
                historyService.save(new History(checkedDoc.getId(), id, checkoutDate, checkedDoc.getDueDate(), 0, 0));
            else {

                historyByIdAndDocId.setStatus(0);
                historyByIdAndDocId.setCheckOutDate(checkoutDate);
                historyByIdAndDocId.setReturnDate(checkedDoc.getDueDate());
                historyService.updateHistory(historyByIdAndDocId);
            }
            System.out.println("The book \"" + doc.getTitle() + "\" are checked out by " + getName());
            log.write(this, "check out" , doc, null);

            return 0;
        }

        else{
            if (doc.getCopies() == 0){
                doc.queue.add(this);
                Queue queueS = new Queue(new Date(System.currentTimeMillis()), doc.getId(), this.getId());
                queueService.save(queueS);

                if (historyByIdAndDocId == null)
                    historyService.save(new History(doc.getId(), id, null, null, 0, 3));
                else {

                    historyByIdAndDocId.setStatus(3);
                    historyByIdAndDocId.setCheckOutDate(null);
                    historyByIdAndDocId.setReturnDate(null);
                    historyService.updateHistory(historyByIdAndDocId);
                }

            }
            System.out.println("No available documents for " + getName());
            return 3;
        }
    }

    public int toReturn(Document doc, Date returnDate)  {
        Long id = userService.findByUsername(this.getUsername()).getId();
        List<History> historyList= historyService.getListHistoriesByIdAndDocId(this.getId(),doc.getId());
        History h = new History();
        if(historyList!=null && !historyList.isEmpty()) {
          h = historyList.get(historyList.size() - 1);
        }
        h.setStatus(1); //Close status
        historyService.updateHistory(h);
        doc.setCopies(doc.getCopies() + 1);
        doc.setRenewed(false);
        documentService.update(doc);

        if (!doc.queue.isEmpty()){
            doc.queue.peek().setNotification("Document " + doc.getTitle() + " is available for you to checkout");
        }

        doc.setCheckoutDate(h.getCheckOutDate());
        long dif = doc.getCheckoutDate().getTime() - returnDate.getTime();

        log.write(this, "return" , doc, null);

        int difDays = (int)TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
        if (difDays > doc.getDue()){
            doc.setOverdue(difDays - doc.getDue());
            if (100 * (difDays - doc.getDue()) < doc.getPrice()) {
                doc.setFine(100 * (difDays - doc.getDue()));
                return doc.getFine();
            }else
                doc.setFine(doc.getPrice());
                return doc.getFine();
        }


        return -1;
    }

    public void renew(Document doc, Date renewDate) {
        if (!doc.wasRenewed()) {
            toReturn(doc, renewDate);
            checkout(doc, renewDate);
            doc.setRenewed(true);
            List<History> historyList= historyService.getListHistoriesByIdAndDocId(this.getId(),doc.getId());
            History history = historyList.get(historyList.size()-1);
            history.setStatus(2);
            historyService.updateHistory(history);
            log.write(this, "renew" , doc, null);

        }
//        History history = historyService.getHistoryByIdAndDocId(this.getId(), doc.getId());
//        if (history.status == 0 && !doc.isRenewed()){
//            Calendar c = Calendar.getInstance();
//            c.setTime(new Date()); // Now use today date.
//            c.add(Calendar.DATE, doc.getDue()); // Adding 5 day
//            Date newReturnDate = c.getTime();
//
//            long diffInMillies = Math.abs(newReturnDate.getTime() - history.getCheckOutDate().getTime());
//            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
//            doc.setDue((int) diff);
//
//            documentService.update(doc);
//            history.setReturnDate(newReturnDate);
//            historyService.updateHistory(history);
//            doc.setRenewed(true);
//        }
    }

    public List<Document> getDocuments() {
        Long id = userService.findByUsername(this.getUsername()).getId();
        List<History> histories = this.historyService.getListOfHistoryByUser(id);
        List<Document> docs = new ArrayList<>();
        for (int i = 0; i < histories.size(); i++){
            if (histories.get(i).status == 0) {
                docs.add(documentService.getDocumentById(histories.get(i).getDocId()));
                docs.get(docs.size() - 1).setCheckoutDate(histories.get(i).checkOutDate);
                System.out.println(this.getName() + " " + histories.get(i).getReturnDate());

                long diffInMillies = Math.abs(histories.get(i).getReturnDate().getTime() - histories.get(i).getCheckOutDate().getTime());
                long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                docs.get(docs.size() - 1).setDue((int) diff);
            }
        }
        return docs;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DocumentService getDocumentService() {
        return documentService;
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }

    public HistoryService getHistoryService() {
        return historyService;
    }

    public void setHistoryService(HistoryService historyService) {
        this.historyService = historyService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public List<Document> searchByFullTitle(String searchString){
        List<Document> documentsAnswerListBySearchString = new ArrayList<>();
        List<Document> documents = documentService.getAllDocuments();
        for (int i = 0; i < documents.size(); i++) {
            Document document = documents.get(i);
            if (document.getTitle().equals(searchString)) {
                documentsAnswerListBySearchString.add(document);
            }
        }
        return documentsAnswerListBySearchString;
    }

    public List<Document> searchByPartTitle(String searchString) {
        List<Document> documentsAnswerListBySearchString = new ArrayList<>();
        List<Document> documents = documentService.getAllDocuments();
        if (searchString.contains(" AND ")) {
            String word1 = searchString.split(" ")[0];
            String word2 = searchString.split(" ")[2];
            for (int i = 0; i < documents.size(); i++) {
                Document document = documents.get(i);
                if (document.getTitle().contains(word1) && document.getTitle().contains(word2)) {
                    documentsAnswerListBySearchString.add(document);
                }
            }
        } else if (searchString.contains(" OR ")) {
            String word1 = searchString.split(" ")[0];
            String word2 = searchString.split(" ")[2];
            for (int i = 0; i < documents.size(); i++) {
                Document document = documents.get(i);
                if (document.getTitle().contains(word1) || document.getTitle().contains(word2)) {
                    documentsAnswerListBySearchString.add(document);
                }
            }
        } else {
            for (int i = 0; i < documents.size(); i++) {
                Document document = documents.get(i);
                if (document.getTitle().contains(searchString)) {
                    documentsAnswerListBySearchString.add(document);
                }
            }
        }
        return documentsAnswerListBySearchString;
    }

    public List<Document> searchByKeywords(String searchString){
        List<Document> documentsAnswerListBySearchString = new ArrayList<>();
        List<Document> documents = documentService.getAllDocuments();
        for (int i = 0; i < documents.size(); i++) {
            Document document = documents.get(i);
            if (document.getKeys().contains(searchString)) {
                documentsAnswerListBySearchString.add(document);
            }
        }
        return documentsAnswerListBySearchString;
    }


}