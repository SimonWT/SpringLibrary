package net.proselyte.springsecurityapp.model.Booking;

import net.proselyte.springsecurityapp.model.Documents.Document;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history")
public class History{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "doc_id")
    public Long docId;

    @Column(name = "user_id")
    public Long userId;

    @Column(name = "co_date")
    public Date checkOutDate;

    @Column(name = "ret_date")
    public Date returnDate;

    @Column(name = "days_penalty")
    public int penaltyDays;

    @Column(name = "status")
    public int status;

    @Transient
    private Document document;

    @Transient
    private int fine;

    public History(Long docId, Long userId, Date checkOutDate, Date returnDate, int penaltyDays, int status) {
        this.docId = docId;
        this.userId = userId;
        this.checkOutDate = checkOutDate;
        this.returnDate = returnDate;
        this.penaltyDays = penaltyDays;
        this.status = status;
    }

    public History() {
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

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getPenaltyDays() {
        return penaltyDays;
    }

    public void setPenaltyDays(int penaltyDays) {
        this.penaltyDays = penaltyDays;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }
}
