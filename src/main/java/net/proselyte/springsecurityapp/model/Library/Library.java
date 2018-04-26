package net.proselyte.springsecurityapp.model.Library;

import net.proselyte.springsecurityapp.dao.UserDao;
import net.proselyte.springsecurityapp.model.Documents.Document;
import net.proselyte.springsecurityapp.model.Users.Librarian;
import net.proselyte.springsecurityapp.model.Users.Patron;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by evgeniy on 13.02.18.
 */
public class Library {
    public ArrayList<Librarian> librarians;
    public ArrayList<Patron> patrons;
    public ArrayList<Document> documents;

//    public List<Document> getDocuments() {
//        return librarians.get(0).docService.ge);
//    }

    public Library(){
        librarians = new ArrayList<>();
        patrons = new ArrayList<>();
        documents = new ArrayList<>();
    }

    public ArrayList<Patron> getPatrons() {
        return (ArrayList<Patron>) librarians.get(0).userService.getAllPatrons();
    }
}
