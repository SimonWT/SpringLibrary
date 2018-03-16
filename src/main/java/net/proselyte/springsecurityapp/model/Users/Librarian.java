package net.proselyte.springsecurityapp.model.Users;

import net.proselyte.springsecurityapp.model.Documents.Document;
import net.proselyte.springsecurityapp.model.Library.Library;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by evgeniy on 21.01.18.
 */


public class Librarian extends User {

    public Library library;

    public void addPatron(Patron newPatron){
        library.patrons.add(newPatron);
        newPatron.library = library;
    }

    public void removePatron(String name, String phoneNumber){
        int id = (name + phoneNumber).hashCode();
        for (Patron patron : library.patrons){
            if (patron.getId() == id)
                library.patrons.remove(patron);
        }
    }

    public Librarian() {
        library = new Library();
    }
    public void addDoc(Document doc, int copiesAmount){
        if (library.documents.contains(doc))
            doc.setCopies(doc.getCopies() + copiesAmount);
        else {
            doc.setCopies(copiesAmount);
            library.documents.add(doc);
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
        if (doc.getCopies() < 0)
            library.documents.remove(doc);
        //rewrite list of documents
    }

    public void removePatron(Patron p){
        library.patrons.remove(p);
    }

    public String checkInfo(Patron p){
        if (!library.patrons.contains(p)){
            return "Information no available, patron does not exist.";
        }
        StringBuilder info = new StringBuilder("Name: " + p.getName() + "\nAddress:" + p.getAddress() + "\nPhone:" + p.getPhone() + "\nId:" + p.getId() + "\nType:" + p.getType() + "\nDocuments:\n");
        for (int i = 0; i < p.getDocuments().size(); i++){
            info.append("\t Title: ").append(p.getDocuments().get(i).getTitle()).append(" Due date: ").append(p.getDocuments().get(i).getDueDate()).append("\n");
        }
        return info.toString();
    }
}
