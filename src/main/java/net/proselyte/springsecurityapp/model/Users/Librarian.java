package net.proselyte.springsecurityapp.model.Users;

import net.proselyte.springsecurityapp.dao.ForTesting.DocDao;
import net.proselyte.springsecurityapp.dao.ForTesting.DocDaoImpl;
import net.proselyte.springsecurityapp.dao.ForTesting.UserDao;
import net.proselyte.springsecurityapp.dao.ForTesting.UserDaoImpl;
import net.proselyte.springsecurityapp.model.Documents.AudioVideo;
import net.proselyte.springsecurityapp.model.Documents.Book;
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
    public UserDao userDao = new UserDaoImpl();
    public DocDao docDao = new DocDaoImpl();

    public void addPatron(Patron newPatron){
        library.getPatrons().add(newPatron);
        newPatron.library = library;
        userDao.addUser(newPatron);
    }

    public void removePatron(String name, String phoneNumber){
        int id = (name + phoneNumber).hashCode();
        for (Patron patron : library.getPatrons()){
            if (patron.getId() == id)
                library.getPatrons().remove(patron);
        }
    }

    public Librarian() {
        library = new Library();
    }
    public void addDoc(Document doc, int copiesAmount){
        if (library.getDocuments().contains(doc))
            doc.setCopies(doc.getCopies() + copiesAmount);
        else {
            doc.setCopies(copiesAmount);
            //library.getDocuments().add(doc);
            if (doc.getClass().toString().equals("class net.proselyte.springsecurityapp.model.Documents.AudioVideo")){
                docDao.addAV((AudioVideo) doc);
            }
            if (doc.getClass().toString().equals("class net.proselyte.springsecurityapp.model.Documents.Book"))
                docDao.addBook((Book) doc);
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
        //if (doc.getCopies() < 0)
         //   library.getDocuments().remove(doc);
        //rewrite list of documents
    }

    public void removePatron(Patron p){
     //   library.getPatrons().remove(p);
    }

    public String checkInfo(Patron p){
        if (!library.getPatrons().contains(p)){
            return "Information not available, patron does not exist.";
        }
        StringBuilder info = new StringBuilder("Name: " + p.getName() + "\nAddress:" + p.getAddress() + "\nPhone:" + p.getPhone() + "\nId:" + p.getId() + "\nType:" + p.getType() + "\nDocuments:\n");

        for (int i = 0; i < p.getDocuments().size(); i++){
            info.append("\t Title: ").append(p.getDocuments().get(i).getTitle()).append(" Due date: ").append(p.getDocuments().get(i).getDueDate()).append("\n");
        }
        return info.toString();
    }

    public void emptyQueues(){
        List <Document> docs = library.getDocuments();
        for (int i = 0; i < docs.size(); i++){
            if (docs.get(i).queue.size() != 0){
                docs.get(i).queue.clear();
            }
        }
    }
}
