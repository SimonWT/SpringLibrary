package net.proselyte.springsecurityapp.model.Booking;

import net.proselyte.springsecurityapp.model.Documents.Document;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "queue")
public class Queue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "doc_id")
    public Long docId;

    @Column(name = "user_id")
    public Long userId;

    @Column(name = "date")
    public Date date;

    @Transient
    private Document document;

    public Queue(Long docId, Long userId, Date date) {
        this.docId = docId;
        this.userId = userId;
        this.date = date;
    }

    public Queue() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
