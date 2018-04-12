package net.proselyte.springsecurityapp.model.Documents;

import net.proselyte.springsecurityapp.model.Users.Patron;
import net.proselyte.springsecurityapp.model.Users.PatronComparator;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Entity
@Table(name = "documents")
@Inheritance(strategy = InheritanceType.JOINED)
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @Column(name = "copies")
    public int copies;

    @Column(name = "title")
    public String title;

    @Column(name = "price")
    public int price;

    @Column(name = "authors")
    public String authors;


    @Transient
    private String keys;

    @Transient
    private int daysRemained;

    @Transient
    private Date checkoutDate;
    @Transient
    private int fine;
    @Transient
    private int overdue;
    @Transient
    public Queue<Patron> queue;
    @Transient
    private int status;
    @Transient
    private boolean renewed;


    //public Document( String title, int price, ArrayList<String> authors, ArrayList<String> keys) {
    public Document(){
        //authors = new ArrayList<String>();
        //keys = new ArrayList<String >();
        queue = new PriorityQueue<>(1, new PatronComparator());
        renewed = false;
    }

    public Document(int copies, String title, int price, String authors) {
        this.copies = copies;
        this.title = title;
        this.price = price;
        this.authors = authors;
    }

    public void setDoc(String title, int price, String authors, String keys){
        this.title = title;
        this.price = price;
        this.authors = authors;
        this.keys = keys;
        this.id = (authors + title).hashCode();
    }

    public void setCopies(int n){
        this.copies = n;
        assert(this.copies == this.getCopies());
    }

    public void setPrice(int newPrice){
        this.price = newPrice;
        assert(this.price == this.getPrice());
    }

    public void resetDate(){
        checkoutDate = new Date();
    }

    public void setDue(int days){
        daysRemained = days;
        assert(this.daysRemained == this.getDue());
    }

    public void setCheckoutDate(String date){
        DateFormat format = new SimpleDateFormat("dd MMM", Locale.ENGLISH);
        try {
            checkoutDate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert(this.checkoutDate.equals(this.getCheckoutDate()));
    }
    public void setCheckoutDate(Date date){
        checkoutDate = date;
        assert(this.checkoutDate.equals(this.getCheckoutDate()));
    }

    public void setFine(int f){
        this.fine = f;
        assert(this.fine == this.getFine());
    }

    public void setOverdue(Date date){
        long dif =  date.getTime() - getCheckoutDate().getTime();
        int difDays = (int) TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
        if (difDays > getDue()){
           this.overdue = (difDays - getDue());
        }
        else{
            this.overdue = 0;
        }
        assert(this.overdue == this.getOverdue());
    }

    public void setOverdue(int overdue){
        this.overdue = overdue;
        assert (this.overdue == this.getOverdue());
    }

    public void setId(long id) {
        this.id = id;
        assert(this.id == this.getId());
    }
    public void setAuthors(String authors){
        this.authors = authors;
        assert(this.authors.equals(this.getAuthors()));
    }
    public void setTitle(String title) {
        this.title = title;
        assert(this.title.equals(this.getTitle()));
    }
    public void setKeys(String keys) {
        this.keys = keys;
        assert(this.keys.equals(this.getKeys()));
    }

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
    public int getFine()
    {
        fine = 100 * this.getOverdue();
        if (fine > price){
            fine = price;
            return price;
        }
        return fine;
    }
    public int getOverdue() { return overdue; }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDueDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getCheckoutDate());
        calendar.add(Calendar.DAY_OF_YEAR, getCheckoutDate().getDay() - 2 + getDue() - 2);
        return calendar.getTime();
    }


    public Document toCopy(){
        Document copy = new Document();
        copy.setDoc(title, price, authors, keys);
        copy.setId(id);
        copy.setOverdue(overdue);
        copy.checkoutDate = checkoutDate;
        copy.setDue(daysRemained);
        copy.setCopies(copies--);
        copy.queue = queue;
        //this.copies--;
        return copy;
    }

    public boolean wasRenewed() {
        return renewed;
    }

    public void setRenewed(boolean renewed) {
        this.renewed = renewed;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", copies=" + copies +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", authors='" + authors + '\'' +
                ", keys='" + keys + '\'' +
                ", daysRemained=" + daysRemained +
                ", checkoutDate=" + checkoutDate +
                ", fine=" + fine +
                ", overdue=" + overdue +
                ", queue=" + queue +
                '}';
    }
}
