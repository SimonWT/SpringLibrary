package system.model.Users;

//import DB.DBtest;
import system.model.Documents.Book;
import system.model.Documents.Document;

import java.util.ArrayList;


/**
 * Created by evgeniy on 21.01.18.
 */
public class Patron extends User {
    public String type; //faculty or student
    public ArrayList <Document> documents; //documents checked by this user
    //DBtest data;
    public Patron(){
        documents = new ArrayList<Document>();
    }

    public void setType(String t){
        type = t;
    }

    public void checkout(Document doc){
        //TODO: get list of documents from db
        if (this.documents.contains(doc)){
            System.out.println("user " + this.name + " already have this document");
            return;
        }
        if (doc.copiesNumber() > 1) {
            documents.add(doc);
            doc.setCopies(doc.copiesNumber() - 1);
            if (!doc.getClass().toString().equals("class Documents.Book")){
                doc.daysRemained = 14;
            }
            else if (this.type.equals("faculty")){
                doc.daysRemained = 28;
            } else{
                Book b = (Book) doc;
                if (b.isBestSeller()){
                    doc.daysRemained = 14;
                }
                else {
                    doc.daysRemained = 21;
                }
            }
            System.out.println("The book \"" + doc.getTitle() + "\" are checked out by " + name);
        }

        else{
            System.out.println("No available documents for " + name);
        }

        //TODO: rewrite list of documents
    }

    public void toReturn(Document doc){
        //TODO get list of documents
        documents.remove(doc);
        doc.setCopies(doc.copiesNumber() + 1);
        //TODO check data and fee
        //TODO rewrite list of documents
    }
}
