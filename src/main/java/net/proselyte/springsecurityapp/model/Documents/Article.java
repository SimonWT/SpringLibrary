package net.proselyte.springsecurityapp.model.Documents;


import javax.persistence.*;
import java.util.Date;

/**
 * Simple JavaBean domain object that represents an Article.
 *
 * @author Igor Vakhula
 */

@Entity
//@Table(name = "journal_articles")
@Table(name = "articles")
public class Article extends Document{

    @Transient
    private Date checkoutDate;

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column(name = "journal_title")
//    private String journal_title;
//
//    @Column(name = "article_title")
//    private String article_title;

//


//    @Column(name = "author")
//    private String author;

    @Column(name = "editors")
    private String editors;

//    @Column(name = "price")
//    private int price;

    @Column(name = "date")
    private Date date;

    @Column(name = "journal")
    private String journal;

    @Transient
    private String dateString;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//        assert(this.id.equals(this.getId()));
//    }
//
//    public String getJournal_title() {
//        return journal_title;
//    }
//
//    public void setJournal_title(String journal_title) {
//        this.journal_title = journal_title;
//        assert (this.journal_title.equals(this.getJournal_title()));
//    }
//
//    public String getArticle_title() {
//        return article_title;
//    }
//
//    public void setArticle_title(String article_title) {
//        this.article_title = article_title;
//        assert (this.article_title.equals(this.getArticle_title()));
//    }
//
//    public String getPublication_month_year() {
//        return publication_month_year;
//    }
//
//    public void setPublication_month_year(String publication_month_year) {
//        this.publication_month_year = publication_month_year;
//        assert (this.publication_month_year.equals(this.getPublication_month_year()));
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//        assert (this.author.equals(this.getAuthor()));
//    }

    public String getEditors() {
        return editors;
    }

    public void setEditor(String editors) {
        this.editors = editors;
        assert (this.editors.equals(this.getEditors()));
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

//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//        assert (this.price == this.getPrice());
//    }
//
//    public int getCopies() {
//        return copies;
//    }
//
//    public void setCopies(int copies) {
//        this.copies = copies;
//        assert (this.copies == this.getCopies());
//    }
//
//    @Column(name = "copies")
//    private int copies;

//    public Article(Long id, String journal_title, String article_title, String publication_month_year, String author, String editor, int price, int copies) {
//        this.id = id;
//        this.journal_title = journal_title;
//        this.article_title = article_title;
//        this.publication_month_year = publication_month_year;
//        this.author = author;
//        this.editor = editor;
//        this.price = price;
//        this.copies = copies;
//    }
//
//    @Override
//    public Article toCopy(){
//        Article copy = (Article) super.toCopy();
//        copy.setDoc(this.getArticle_title(), price, this.getAuthors(), this.getKeys());
//        copy.setId(id);
//        copy.setOverdue(this.getOverdue());
//        copy.setFine(this.getFine());
//        copy.checkoutDate = checkoutDate;
//        copy.setDue(this.getDue());
//        copy.setCopies(copies--);
//        copy.setArticle_title(article_title);
//        copy.setJournal_title(journal_title);
//        copy.setPublication_month_year(publication_month_year);
//        copy.setEditor(editor);
//        return copy;
//    }
//
//    @Override
//    public String toString() {
//        return "Article{" +
//                "id=" + id +
//                ", journal_title='" + journal_title + '\'' +
//                ", article_title='" + article_title + '\'' +
//                ", publication_month_year='" + publication_month_year + '\'' +
//                ", author='" + author + '\'' +
//                ", editor='" + editor + '\'' +
//                ", price=" + price +
//                ", copies=" + copies +
//                '}';
//    }
//
//    public Article() {
//
//    }


    public Article() {

    }

    public Article(int copies, String title, int price, String authors, String editors, Date date, String journal) {
        super(copies, title, price, authors);
        this.editors = editors;
        this.date = date;
        this.journal = journal;
    }
}
