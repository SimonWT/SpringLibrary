package net.proselyte.springsecurityapp.model.Documents;


import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Simple JavaBean domain object that represents an Article.
 *
 * @author Igor Vakhula
 */

@Entity
//@Table(name = "journal_articles")
@Table(name = "articles")
public class Article extends Document{

    @Column(name = "editors")
    private String editors;

    @Column(name = "date")
    private Date date;

    @Column(name = "journal")
    private String journal;

    @Transient
    private Date checkoutDate;

    @Transient
    private String dateString;

    public String getEditors() {
        return editors;
    }

    public void setEditors(String editors) {
        this.editors = editors;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public void parseDate() throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        if(this.dateString.length()!=0) {
            java.util.Date date = format.parse(this.dateString);
            System.out.println(date); // 2010-01-02
            this.date = date;
        }
    }

    public Article() {

    }

    public Article(int copies, String title, int price, String authors, String editors, Date date, String journal) {
        super(copies, title, price, authors);
        this.editors = editors;
        this.date = date;
        this.journal = journal;
    }
}
