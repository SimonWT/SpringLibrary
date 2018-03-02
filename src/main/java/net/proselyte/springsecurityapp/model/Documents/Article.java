package net.proselyte.springsecurityapp.model.Documents;

import java.util.ArrayList;

public class Article extends Document {

    private String editor;
    private String journal;
    private String date;

    public Article(String title, int price, ArrayList<String> author, ArrayList<String> keys, String editor, String journal, String date) {
        //super(title, price, author, keys);
        this.editor = editor;
        this.journal = journal;
        this.date = date;
    }

    public String getEditor(){return editor;}
    public String getJournal(){return journal;}
    public String getDate(){return date;}

}
