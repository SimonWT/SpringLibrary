package net.proselyte.springsecurityapp.model;


import javax.persistence.*;

/**
 * Simple JavaBean domain object that represents an Article.
 *
 * @author Igor Vakhula
 */

@Entity
@Table(name = "journal_articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "journal_title")
    private String journal_title;

    @Column(name = "article_title")
    private String article_title;

    @Column(name = "publication_month_year")
    private String publication_month_year;

    @Column(name = "author")
    private String author;

    @Column(name = "editor")
    private String editor;

    @Column(name = "price")
    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJournal_title() {
        return journal_title;
    }

    public void setJournal_title(String journal_title) {
        this.journal_title = journal_title;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getPublication_month_year() {
        return publication_month_year;
    }

    public void setPublication_month_year(String publication_month_year) {
        this.publication_month_year = publication_month_year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
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

    @Column(name = "copies")
    private int copies;

    public Article(Long id, String journal_title, String article_title, String publication_month_year, String author, String editor, int price, int copies) {
        this.id = id;
        this.journal_title = journal_title;
        this.article_title = article_title;
        this.publication_month_year = publication_month_year;
        this.author = author;
        this.editor = editor;
        this.price = price;
        this.copies = copies;
    }

    public Article() {

    }
}
