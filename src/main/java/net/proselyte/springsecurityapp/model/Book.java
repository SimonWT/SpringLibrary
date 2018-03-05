package net.proselyte.springsecurityapp.model;

import javax.persistence.*;

/**
 * Simple JavaBean domain object that represents a Book.
 *
 * @author Igor Vakhula
 */

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "year")
    private String year;

    @Column(name = "edition")
    private int edition;

    @Column(name = "price")
    private int price;

    @Column(name = "copies")
    private int copies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public Book(Long id, String title, String author, String year, int edition, int price, int copies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.edition = edition;
        this.price = price;
        this.copies = copies;
    }
    public Book() {

    }
}