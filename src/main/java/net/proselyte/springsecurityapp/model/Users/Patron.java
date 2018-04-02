package net.proselyte.springsecurityapp.model.Users;

import net.proselyte.springsecurityapp.model.Booking.History;
import net.proselyte.springsecurityapp.model.Documents.Book;
import net.proselyte.springsecurityapp.model.Documents.Document;
import net.proselyte.springsecurityapp.model.Documents.Role;
import net.proselyte.springsecurityapp.model.Library.Library;
import net.proselyte.springsecurityapp.service.DocumentService;
import net.proselyte.springsecurityapp.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * Created by evgeniy on 21.01.18.
 */

@Entity
@DiscriminatorValue("Patron")
public class Patron extends User {


    @Column(name = "address")
    private String address;

    @Transient
    private DocumentService documentService;

    @Transient
    private HistoryService historyService;

    @Transient
    private ArrayList <Document> documents; //documents checked by this user

    @Transient
    private Library library;

    public Patron(){};

    public Patron(String username, String password, String name, String surname, String phone, String email, String type, String address) {
        super(username, password, name, surname, phone, email, type);
        this.address = address;
    }


    public int checkout(Document doc){
        if (!library.getPatrons().contains(this)){
            System.out.println("You have not registered in system. Ask librarian to register you in system");
            return 1;
        }
        //TODO: Check branches
        if (this.documents.contains(doc) || historyService.getHistoryByIdAndDocId(getId(),doc.getId()).getStatus() == 0 ){
            System.out.println("user " + getName() + " already have this document");
            return 2;
        }
        if (library.getDocuments().contains(doc) && doc.getCopies() > 0 && !doc.getKeys().contains("reference")) {
            Document checkedDoc = doc.toCopy();
            documents.add(checkedDoc);

            //doc.patron = this;
            //doc.resetDate();
            //doc.setCopies(doc.getCopies() - 1);


            if (!(doc instanceof Book)){
                checkedDoc.setDue(14);
            }
            else if (this instanceof Faculty){
                checkedDoc.setDue(28);
            } else{
                Book b = (Book) checkedDoc;
                if (b.isBestSeller()){
                    checkedDoc.setDue(14);
                }
                else {
                    checkedDoc.setDue(21);
                }
            }
            checkedDoc.setCheckoutDate(new Date());
            historyService.save(new History(checkedDoc.getId(), getId(), new Date(System.currentTimeMillis()), checkedDoc.getDueDate(), 0, 0));
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

    public void toReturn(Document doc){
        documents.remove(doc);
        doc.setCopies(doc.getCopies() + 1);
        Date today = new Date();
        long dif = doc.getCheckoutDate().getTime() - today.getTime();
        int difDays = (int)TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
        if (difDays > doc.getDue()){
            doc.setOverdue(difDays - doc.getDue());
            if (100 * (difDays - doc.getDue()) < doc.getPrice())
                doc.setFine(100 * (difDays - doc.getDue()));
            else
                doc.setFine(doc.getPrice());
        }
    }

    public ArrayList<Document> getDocuments() {
        return documents;
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
}