package net.proselyte.springsecurityapp.model.Tests;

import net.proselyte.springsecurityapp.model.AudioVideo;
import net.proselyte.springsecurityapp.model.Book;
import net.proselyte.springsecurityapp.model.Documents.Document;
import net.proselyte.springsecurityapp.model.Users.Librarian;
import net.proselyte.springsecurityapp.model.Users.Patron;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class TestCases_07_03 {
    public static void testCase8(){
        Librarian librarian = new Librarian();
        Patron p1 = new Patron();
        Patron p2 = new Patron();
        librarian.addPatron(p1);
        librarian.addPatron(p2);

        Book b1 = new Book();
        Book b2 = new Book();
        librarian.addDoc(b1);
        librarian.addDoc(b2);
        AudioVideo av1 = new AudioVideo();
        librarian.addDoc(av1);

        p1.setName("Sergey Afonso");
        p1.setAddress("Via Margutta, 3");
        p1.setPhone("30001");
        p1.setId((long) 1010);
        p1.setType("Faculty");

        p2.setName("Nadia Teixeira");
        p2.setAddress("Via Sacra, 13");
        p2.setPhone("30002");
        p2.setId((long) 1011);
        p2.setType("Student");

        b1.setTitle("Introduction to Algorithms");
        b1.setAuthor("Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and Clifford Stein");
        b1.setYear("2009");
        b1.setEdition(3);
        b1.setBestSeller(false);

        b2.setTitle("Design Patterns: Elements of Reusable Object-Oriented Software");
        b2.setAuthor("Erich Gamma, Ralph Johnson, John Vlissides, Richard Helm");
        b2.setYear("2003");
        b2.setEdition(1);
        b2.setBestSeller(true);

        av1.setTitle("Null References: The Billion Dollar Mistake");
        av1.setAuthors("Tony Hoare");

        b1.setCopies(3);
        b2.setCopies(2);
        av1.setCopies(2);

        p1.checkout(b1.toCopy());
        p1.getDocuments().get(0).setCheckoutDate("February 9, 2018");
        p1.checkout(b2);
        p1.getDocuments().get(1).setCheckoutDate("February 2, 2018");

        p2.checkout(b1.toCopy());
        p2.getDocuments().get(0).setCheckoutDate("February 5, 2018");
        p2.checkout(av1.toCopy());
        p2.getDocuments().get(1).setCheckoutDate("February 17, 2018");

        System.out.println();
        String string = "March 5, 2018";
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        try {
            Date date = format.parse(string);
            ArrayList<Document> overdue1 = librarian.overdueDocuments(p1, date);
            System.out.println(p1.getName() + " overdue: ");
            for (int i = 0; i < overdue1.size(); i++){
                System.out.println("\"" + overdue1.get(i).getTitle() + "\"" + " " + overdue1.get(i).getOverdue() + " days");
            }
            ArrayList<Document> overdue2 = librarian.overdueDocuments(p2, date);
            System.out.println(p2.getName() + " overdue: ");
            for (int i = 0; i < overdue2.size(); i++){
                System.out.println("\"" + overdue2.get(i).getTitle() + "\"" + " " + overdue2.get(i).getOverdue() + " days");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        testCase8();
    }
}
