package net.proselyte.springsecurityapp.model.Users;

import net.proselyte.springsecurityapp.model.Documents.Book;
import net.proselyte.springsecurityapp.model.Documents.Document;
import net.proselyte.springsecurityapp.model.Documents.Role;
import net.proselyte.springsecurityapp.model.Library.Library;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * Created by evgeniy on 21.01.18.
 */

@Entity
@DiscriminatorValue("PATRON")
public class Patron extends User {
    private String type; //faculty or student
    private ArrayList <Document> documents; //documents checked by this user
    private String address;
    public Library library;

    public Patron(){
        documents = new ArrayList<>();
    }

    public void setType(String t){
        type = t;
    }

    public void checkout(Document doc){
        if (!library.patrons.contains(this)){
            System.out.println("You have not registered in system. Ask librarian to register you in system");
            return;
        }
        if (this.documents.contains(doc)){
            System.out.println("user " + getName() + " already have this document");
            return;
        }
        if (library.documents.contains(doc) && doc.getCopies() > 0 && !doc.getKeys().equals("reference")) {
            Document checkedDoc = doc.toCopy();
            documents.add(checkedDoc);
            //doc.patron = this;
            //doc.resetDate();
            //doc.setCopies(doc.getCopies() - 1);
            if (!doc.getClass().toString().equals("class net.proselyte.springsecurityapp.model.Documents.Book")){
                checkedDoc.setDue(14);
            }
            else if (this.getType().equals("Faculty")){
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
            System.out.println("The book \"" + doc.getTitle() + "\" are checked out by " + getName());
        }

        else{
            System.out.println("No available documents for " + getName());
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

    public String getType() {
        return type;
    }
}