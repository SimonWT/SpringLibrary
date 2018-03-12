package net.proselyte.springsecurityapp.model.Documents;


import net.proselyte.springsecurityapp.model.Documents.Document;

import javax.persistence.*;

/**
 * Simple JavaBean domain object that represents a Audio or Video material.
 *
 * @author Igor Vakhula
 */

@Entity
@Table(name = "audio_video")
public class AudioVideo extends Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "author")
    private String author;

    @Column(name = "title")
    private String title;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice(){
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

    public AudioVideo(Long id, String author, String title, int price, int copies) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.price = price;
        this.copies = copies;
    }

    public AudioVideo() {

    }
}
