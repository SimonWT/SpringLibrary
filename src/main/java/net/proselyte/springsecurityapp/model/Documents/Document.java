package net.proselyte.springsecurityapp.model.Documents;

import java.util.ArrayList;
import java.util.Date;

public class Document {
    private int id;
    private int copies;
    private String title;
    private int price;
    private ArrayList<String> authors;
    private ArrayList<String> keys;
    private int daysRemained;
    private Date checkoutDate;
    private int fine;


    //public Document( String title, int price, ArrayList<String> authors, ArrayList<String> keys) {
    public Document(){
        authors = new ArrayList<String>();
        keys = new ArrayList<String >();
    }

    public void setDoc(String title, int price, String authors, String keys){
        this.title = title;
        this.price = price;
        this.authors.add(authors);
        this.keys.add(keys);
        this.id = (authors + title).hashCode();
    }

    public void setCopies(int n){this.copies = n;}
    public void setPrice(int newPrice){this.price = newPrice;}
    public void resetDate(){checkoutDate = new Date();}
    public void setDue(int days){daysRemained = days;}
    public void setFine(int f){fine = f;}

    public int copiesNumber(){
        return copies;
    }
    public String getTitle(){return title;}
    public int getPrice(){return price;}
    public ArrayList<String> getAuthors(){return authors;}
    public ArrayList<String> getKeys(){return keys;}
    public int getId(){return id;}
    public Date getCheckoutDate(){return checkoutDate;}
    public int getDue(){return daysRemained;}
    public int getFine(){return fine;}
}
