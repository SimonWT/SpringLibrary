package net.proselyte.springsecurityapp.model.Users;

import net.proselyte.springsecurityapp.model.Booking.History;
import net.proselyte.springsecurityapp.model.Documents.Book;
import net.proselyte.springsecurityapp.model.Documents.Document;
import net.proselyte.springsecurityapp.model.Documents.Role;
import net.proselyte.springsecurityapp.model.Library.Library;
import net.proselyte.springsecurityapp.service.DocumentService;
import net.proselyte.springsecurityapp.service.HistoryService;
import net.proselyte.springsecurityapp.service.UserService;
import net.proselyte.springsecurityapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.print.Doc;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
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

    public Patron(){};

    public Patron(String username, String password, String name, String surname, String phone, String email, String type, String address) {
        super(username, password, name, surname, phone, email, type);
        this.address = address;
    }


    public int checkout(Document doc, Date checkoutDate){

        if (userService.getAllPatrons().contains(this)){
            System.out.println("You have not registered in system. Ask librarian to register you in system");
            return 1;
        }
        //TODO: Check branches, Copies of Doc -1
        History historyByIdAndDocId = historyService.getHistoryByIdAndDocId(this.getId(),doc.getId());

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
                historyService.save(new History(checkedDoc.getId(), this.getId(), checkoutDate, checkedDoc.getDueDate(), 0, 0));
            else {
                historyByIdAndDocId.setStatus(0);
                historyByIdAndDocId.setCheckOutDate(checkoutDate);
                historyByIdAndDocId.setReturnDate(checkedDoc.getDueDate());
                historyService.updateHistory(historyByIdAndDocId);
            }
            System.out.println("The book \"" + doc.getTitle() + "\" are checked out by " + getName());
            return 0;
        }

        else{
            if (doc.getCopies() == 0){
                doc.queue.add(this);
            }
            System.out.println("No available documents for " + getName());
            return 3;
        }
    }

    public int toReturn(Document doc, Date returnDate){
        History h = historyService.getHistoryByIdAndDocId(this.getId(), doc.getId());
        h.setStatus(1); //Close status
        historyService.updateHistory(h);
        doc.setCopies(doc.getCopies() + 1);
        //doc.setRenewed(false);
        documentService.update(doc);

        doc.setCheckoutDate(h.getCheckOutDate());
        long dif = doc.getCheckoutDate().getTime() - returnDate.getTime();

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

    public void renew(Document doc, Date renewDate){
        doc.setOldReturnDate(historyService.getHistoryByIdAndDocId(this.getId(), doc.getId()).returnDate);
        toReturn(doc, renewDate);
        checkout(doc, renewDate);
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
        List<History> histories = this.historyService.getListOfHistoryByUser(this.getId());
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
}