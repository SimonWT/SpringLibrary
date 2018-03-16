package net.proselyte.springsecurityapp.model.Library;

import net.proselyte.springsecurityapp.model.Documents.Document;
import net.proselyte.springsecurityapp.model.Users.Librarian;
import net.proselyte.springsecurityapp.model.Users.Patron;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by evgeniy on 13.02.18.
 */
public class Library {
    public ArrayList<Librarian> librarians;
    public ArrayList<Patron> patrons;
    public ArrayList<Document> documents;

    public Library(){
        librarians = new ArrayList<>();
        patrons = new ArrayList<>();
        documents = new ArrayList<>();
    }

}
