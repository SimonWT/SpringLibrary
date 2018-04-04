package net.proselyte.springsecurityapp.model.Documents;

import sun.util.calendar.BaseCalendar;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;
import java.util.Locale;

/**
 * Simple JavaBean domain object that represents a Book.
 *
 * @author Igor Vakhula
 */

@Entity
@Table(name = "books2")
public class Book extends Document {

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "bestseller")
    private boolean bestSeller;

    @Transient
    private Date checkoutDate;



    @Column(name = "year")
    private Date year;

    @Transient
    private String yearString;

    @Column(name = "edition")
    private int edition;

    public boolean isBestSeller() {
        return bestSeller;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
        assert(this.edition == this.getEdition());
    }
    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
        assert(this.authors == this.getAuthors());
    }

    public void setBestSeller(boolean bestSeller) {
        this.bestSeller = bestSeller;
        assert(this.bestSeller == this.isBestSeller());
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }



    public Book(int copies, String title, int price, String authors, String publisher, boolean bestSeller, Date year, int edition) {
        super(copies, title, price, authors);
        this.publisher = publisher;
        this.bestSeller = bestSeller;
        this.year = year;
        this.edition = edition;
    }




    public Book() {

    }

//    @Column(name = "price")
//    private int price;
//
//    @Column(name = "copies")
//    private int copies;

//    public Long getId() {
//        return id;
//    }

//    public void setId(Long id) {
//        this.id = id;
//        assert(this.id.equals(this.getId()));
//    }

//    public String getTitle() {
//        return title;
//    }

//    @Override
//    public Book toCopy(){
//        Book copy = new Book(id, title, super.authors, year, edition, price, copies--);
//        copy.setOverdue(this.getOverdue());
//        copy.setFine(this.getFine());
//        copy.checkoutDate = checkoutDate;
//        copy.setDue(this.getDue());
//        copy.setBestSeller(bestSeller);
//        //this.copies--;
//        return copy;
//    }
//    public Book(Long id, String title, String author, String year, int edition, int price, int copies) {
//        this.id = id;
//        this.title = title;
//        this.author = author;
//        this.year = year;
//        this.edition = edition;
//        this.price = price;
//        this.copies = copies;
//    }
    //    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//        assert(this.price == this.getPrice());
//    }
//
//    public int getCopies() {
//        return copies;
//    }
//
//    public void setCopies(int copies) {
//        this.copies = copies;
//        assert(this.copies == this.getCopies());
//    }
//////    @Id
//////    @GeneratedValue(strategy = GenerationType.AUTO)
//////    private Long id;
////
////    @Column(name = "title")
////    private String title;
////
////    @Column(name = "author")
////    private String author;
//    @Column(name = "price")
//    private int price;
//
//    @Column(name = "copies")
//    private int copies;

//    public Long getId() {
//        return id;
//    }

//    public void setId(Long id) {
//        this.id = id;
//        assert(this.id.equals(this.getId()));
//    }

//    public String getTitle() {
//        return title;
//    }
//    public void setTitle(String title) {
//        this.title = title;
//        assert(this.title.equals(this.getTitle()));
//    }

    //    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//        assert(this.author.equals(this.getAuthor()));
//    }


    public String getYearString() {
        return yearString;
    }

    public void setYearString(String yearString) {
        this.yearString = yearString;
    }

    public void parseDate() throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        if(this.yearString.length()!=0) {
            java.util.Date date = format.parse(this.yearString);
            System.out.println(date); // 2010-01-02
            this.year = date;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "publisher='" + publisher + '\'' +
                ", bestSeller=" + bestSeller +
                ", year=" + year +
                ", edition=" + edition +
                ", id=" + id +
                ", copies=" + copies +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", authors='" + authors + '\'' +
                '}';
    }
}
