package net.proselyte.springsecurityapp.model.Users;

import net.proselyte.springsecurityapp.model.Documents.Document;
import net.proselyte.springsecurityapp.model.User;

import java.util.ArrayList;

/**
 * Created by evgeniy on 21.01.18.
 */
public class Librarian extends User {

    public ArrayList<Patron> patrons;
    public ArrayList<Document> documents;

    public void addPatron(Patron newPatron){
        patrons.add(newPatron);
    }

    public void removePatron(String name, String phoneNumber){
        int id = (name + phoneNumber).hashCode();
        for (Patron patron : patrons){
            if (patron.getId() == id)
                patrons.remove(patron);
        }
    }

    public Librarian() {
        patrons = new ArrayList<Patron>();
        documents = new ArrayList<Document>();
    }
    public void add(Document doc){
        if (documents.contains(doc))
            doc.setCopies(doc.copiesNumber() + 1);
        else
            documents.add(doc);
    }

    public void modify(Document doc){
        //new attributes for documents get from the input window on site
        int price = 0;
        String authors = null, title = null, keys = null;
        doc.setDoc(title, price, authors, keys);
    }

    public void remove(Document doc){
        //get list of documents
        documents.remove(doc);
        //rewrite list of documents
    }
}
