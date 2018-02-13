package system.model.Users;

import system.model.Documents.Document;

import java.util.ArrayList;

/**
 * Created by evgeniy on 21.01.18.
 */
public class Librarian extends User {

    public ArrayList<Patron> patrons;
    public ArrayList<Document> documents;

    public void addPatron(Patron newPatron){//String name, String phoneNumber, String email, String type){
//        Patron newPatron = new Patron();
//        newPatron.name = name;
//        newPatron.phone_number = phoneNumber;
//        newPatron.email = email;
//        newPatron.id = (name + phoneNumber).hashCode();
//        newPatron.type = type;
        patrons.add(newPatron);
    }

    public void removePatron(String name, String phoneNumber){
        int id = (name + phoneNumber).hashCode();
        for (Patron patron : patrons){
            if (patron.id == id)
                patrons.remove(patron);
        }
    }

    //public Librarian(String name, String phoneNumber, String email, int id) {
    public Librarian() {
        //super(name, phoneNumber, email, id);
        patrons = new ArrayList<Patron>();
        documents = new ArrayList<Document>();
    }
    public void add(Document doc){
        documents.add(doc);
    }

    public void modify(){

    }

    public void remove(Document doc){
        //get list of documents
        documents.remove(doc);
        //rewrite list of documents
    }
}
