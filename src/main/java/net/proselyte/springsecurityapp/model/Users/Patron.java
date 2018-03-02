package net.proselyte.springsecurityapp.model.Users;

import net.proselyte.springsecurityapp.model.Documents.Book;
import net.proselyte.springsecurityapp.model.Documents.Document;
import net.proselyte.springsecurityapp.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * Created by evgeniy on 21.01.18.
 */
public class Patron extends User {
    private String type; //faculty or student
    private ArrayList <Document> documents; //documents checked by this user

    public Patron(){
        documents = new ArrayList<Document>();
    }

    public void setType(String t){
        type = t;
    }

    public void checkout(Document doc){
        //TODO: get list of documents from db
        if (this.documents.contains(doc)){
            System.out.println("user " + getName() + " already have this document");
            return;
        }
        if (doc.copiesNumber() > 1) {
            documents.add(doc);
            doc.resetDate();
            doc.setCopies(doc.copiesNumber() - 1);
            if (!doc.getClass().toString().equals("class Documents.Book")){
                doc.setDue(14);
            }
            else if (this.type.equals("faculty")){
                doc.setDue(28);
            } else{
                Book b = (Book) doc;
                if (b.isBestSeller()){
                    doc.setDue(14);
                }
                else {
                    doc.setDue(21);
                }
            }
            System.out.println("The book \"" + doc.getTitle() + "\" are checked out by " + getName());
        }

        else{
            System.out.println("No available documents for " + getName());
        }

        //TODO: rewrite list of documents
    }

    public void toReturn(Document doc){
        //TODO get list of documents
        documents.remove(doc);
        doc.setCopies(doc.copiesNumber() + 1);
        Date today = new Date();
        long dif = doc.getCheckoutDate().getTime() - today.getTime();
        int difDays = (int)TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
        if (difDays > doc.getDue()){
            if (100 * (difDays - doc.getDue()) < doc.getPrice())
                doc.setFine(100 * (difDays - doc.getDue()));
            else
                doc.setFine(doc.getPrice());
        }
        //TODO rewrite list of documents
    }
}