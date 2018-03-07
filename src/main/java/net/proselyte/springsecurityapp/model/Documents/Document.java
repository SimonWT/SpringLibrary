package net.proselyte.springsecurityapp.model.Documents;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Document {
    private long id;
    private int copies;
    private String title;
    private int price;
    private String authors;
    private String keys;
    private int daysRemained;
    private Date checkoutDate;
    private int fine;
    private int overdue;


    //public Document( String title, int price, ArrayList<String> authors, ArrayList<String> keys) {
    public Document(){
        //authors = new ArrayList<String>();
        //keys = new ArrayList<String >();
    }

    public void setDoc(String title, int price, String authors, String keys){
        this.title = title;
        this.price = price;
        this.authors = authors;
        this.keys = keys;
        this.id = (authors + title).hashCode();
    }

    public void setCopies(int n){this.copies = n;}
    public void setPrice(int newPrice){this.price = newPrice;}
    public void resetDate(){checkoutDate = new Date();}
    public void setDue(int days){daysRemained = days;}
    public void setCheckoutDate(String date){
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        try {
            checkoutDate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public void setCheckoutDate(Date date){ checkoutDate = date;}
    public void setFine(int f){ fine = f;}
    public void setOverdue(int overdue){ this.overdue = overdue;}
    public void setId(long id) { this.id = id; }
    public void setAuthors(String authors){ this.authors = authors;}
    public void setTitle(String title) { this.title = title; }
    public void setKeys(String keys) { this.keys = keys; }

    public int getCopies(){
        return copies;
    }
    public String getTitle(){return title;}
    public int getPrice(){return price;}
    public String getAuthors(){return authors;}
    public String getKeys(){return keys;}
    public Long getId(){return id;}
    public Date getCheckoutDate(){return checkoutDate;}
    public int getDue(){return daysRemained;}
    public int getFine(){return fine;}
    public int getOverdue() { return overdue; }

    public Date getDueDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getCheckoutDate());
        calendar.add(Calendar.DAY_OF_YEAR, getCheckoutDate().getDay() - 1 + getDue() - 1);
        return calendar.getTime();
    }

    public Document toCopy(){
        Document copy = new Document();
        copy.setDoc(title, price, authors, keys);
        copy.setId(id);
        copy.setOverdue(overdue);
        copy.setFine(fine);
        copy.checkoutDate = checkoutDate;
        copy.setDue(daysRemained);
        copy.setCopies(copies--);
        //this.copies--;
        return copy;
    }

}
