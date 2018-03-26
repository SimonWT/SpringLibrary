package net.proselyte.springsecurityapp.model.Documents;

import sun.util.calendar.BaseCalendar;

import javax.persistence.*;
import java.time.Year;
import java.util.Date;

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

////    @Id
////    @GeneratedValue(strategy = GenerationType.AUTO)
////    private Long id;
//
//    @Column(name = "title")
//    private String title;
//
//    @Column(name = "author")
//    private String author;

    @Column(name = "year")
    private java.sql.Date year;

    @Column(name = "edition")
    private int edition;

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

    public boolean isBestSeller() {
        return bestSeller;
    }

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


    public java.sql.Date getYear() {
        return year;
    }

    public void setYear(java.sql.Date year) {
        this.year = year;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
        assert(this.edition == this.getEdition());
    }

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

    //    public Book(Long id, String title, String author, String year, int edition, int price, int copies) {
//        this.id = id;
//        this.title = title;
//        this.author = author;
//        this.year = year;
//        this.edition = edition;
//        this.price = price;
//        this.copies = copies;
//    }

    public Book(int copies, String title, int price, String authors, String publisher, boolean bestSeller, java.sql.Date year, int edition) {
        super(copies, title, price, authors);
        this.publisher = publisher;
        this.bestSeller = bestSeller;
        this.year = year;
        this.edition = edition;
    }


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

    public Book() {

    }


//    @Override
//    public String toString() {
//        return "Book{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", author='" + author + '\'' +
//                ", year='" + year + '\'' +
//                ", edition=" + edition +
//                ", price=" + price +
//                ", copies=" + copies +
//                '}';
//    }
}
