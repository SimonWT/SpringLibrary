package net.proselyte.springsecurityapp.model.Tests;

import net.proselyte.springsecurityapp.model.Documents.AudioVideo;
import net.proselyte.springsecurityapp.model.Documents.Book;
import net.proselyte.springsecurityapp.model.Documents.Document;
import net.proselyte.springsecurityapp.model.Library.Library;
import net.proselyte.springsecurityapp.model.Users.Librarian;
import net.proselyte.springsecurityapp.model.Users.Patron;
import net.proselyte.springsecurityapp.model.Users.User;
import net.proselyte.springsecurityapp.service.UserService;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestCases_07_03 {

    static Library library;
    static Book b1;
    static Book b2;
    static Book b3;
    static AudioVideo av1, av2;
    static Patron p1, p2, p3;
    static Librarian librarian;

    @Test
    public static void testCase1(){
        librarian.addDoc(b1, 3);
        librarian.addDoc(b2, 2);
        librarian.addDoc(b3, 1);

        librarian.addDoc(av1, 1);
        librarian.addDoc(av2, 1);

        librarian.addPatron(p1);
        librarian.addPatron(p2);
        librarian.addPatron(p3);

        System.out.println(librarian.library.getPatrons().size() + 1 + " users in system");

        int docNum = 0;

        ArrayList<Document> docs = (ArrayList<Document>) librarian.library.getDocuments();
        for (int i = 0; i < docs.size(); i++){
            docNum += docs.get(i).getCopies();
        }

        System.out.println(docNum + " documents in system");

    }

    @Test
    public static void testCase2(){
        testCase1();
        librarian.removePatron(p2);
        librarian.removeDoc(b1, 2);
        librarian.removeDoc(b3, 1);
        System.out.println(b1.getClass());

        System.out.println(library.getPatrons().size() + library.librarians.size() + " users in system");

        int docNum = 0;

        ArrayList<Document> docs = (ArrayList<Document>) librarian.library.getDocuments();
        for (int i = 0; i < docs.size(); i++){
            docNum += docs.get(i).getCopies();
        }

        System.out.println(docNum + " documents in system");

    }

    @Test
    public static void testCase3(){
        testCase1();
        System.out.println(librarian.checkInfo(p1));
        System.out.println(librarian.checkInfo(p3));
    }

    @Test
    public static void testCase4(){
        testCase2();
        System.out.println(librarian.checkInfo(p2));
        System.out.println(librarian.checkInfo(p3));
    }

    @Test
    public static void testCase5(){
        testCase2();
        p2.checkout(b1);
    }

    @Test
    public static void testCase6(){
        testCase2();
        p1.checkout(b1);
        String today = "March 5, 2018";
        if (p1.getDocuments().size() != 0 && p1.getDocuments().get(p1.getDocuments().size() - 1) != null )
            p1.getDocuments().get(p1.getDocuments().size() - 1).setCheckoutDate(today);
        p3.checkout(b2);
        if (p3.getDocuments().size() != 0 && p3.getDocuments().get(p3.getDocuments().size() - 1) != null )
            p3.getDocuments().get(p3.getDocuments().size() - 1).setCheckoutDate(today);
        p1.checkout(b1);
        if (p1.getDocuments().size() != 0 && p1.getDocuments().get(p1.getDocuments().size() - 1) != null )
            p1.getDocuments().get(p1.getDocuments().size() - 1).setCheckoutDate(today);

        System.out.println();
        System.out.println();

        System.out.println(librarian.checkInfo(p1));
        System.out.println(librarian.checkInfo(p3));
    }

    @Test
    public static void testCase7(){
        testCase1();

        p1.checkout(b1);
        String today = "March 5, 2018";
        if (p1.getDocuments().size() != 0 && p1.getDocuments().get(p1.getDocuments().size() - 1) != null )
            p1.getDocuments().get(p1.getDocuments().size() - 1).setCheckoutDate(today);
        p1.checkout(b2);
        if (p1.getDocuments().size() != 0 && p1.getDocuments().get(p1.getDocuments().size() - 1) != null )
            p1.getDocuments().get(p1.getDocuments().size() - 1).setCheckoutDate(today);
        p1.checkout(b3);
        if (p1.getDocuments().size() != 0 && p1.getDocuments().get(p1.getDocuments().size() - 1) != null )
            p1.getDocuments().get(p1.getDocuments().size() - 1).setCheckoutDate(today);
        p1.checkout(av1);
        if (p1.getDocuments().size() != 0 && p1.getDocuments().get(p1.getDocuments().size() - 1) != null )
            p1.getDocuments().get(p1.getDocuments().size() - 1).setCheckoutDate(today);

        p2.checkout(b1);
        if (p2.getDocuments().size() != 0 && p2.getDocuments().get(p2.getDocuments().size() - 1) != null )
            p2.getDocuments().get(p2.getDocuments().size() - 1).setCheckoutDate(today);
        p2.checkout(b2);
        if (p2.getDocuments().size() != 0 && p2.getDocuments().get(p2.getDocuments().size() - 1) != null )
            p2.getDocuments().get(p2.getDocuments().size() - 1).setCheckoutDate(today);
        p2.checkout(av2);
        if (p2.getDocuments().size() != 0 && p2.getDocuments().get(p2.getDocuments().size() - 1) != null )
            p2.getDocuments().get(p2.getDocuments().size() - 1).setCheckoutDate(today);

        System.out.println(librarian.checkInfo(p1));
        System.out.println(librarian.checkInfo(p2));
    }

    @Test
    public static void testCase8(){
        librarian.addPatron(p1);
        librarian.addPatron(p2);

        librarian.addDoc(b1, 3);
        librarian.addDoc(b2, 2);
        librarian.addDoc(av1, 2);

        b1.setCopies(3);
        b2.setCopies(2);
        av1.setCopies(2);

        p1.checkout(b1);
        p1.getDocuments().get(0).setCheckoutDate("February 9, 2018");
        p1.checkout(b2);
        p1.getDocuments().get(1).setCheckoutDate("February 2, 2018");

        p2.checkout(b1);
        p2.getDocuments().get(0).setCheckoutDate("February 5, 2018");
        p2.checkout(av1);
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

    @Test
    public static void testCase9(){
        List<Patron> patrons = librarian.userDao.getPatrons();
        System.out.println("Patrons:");
        for (int i = patrons.size() - 3; i < patrons.size(); i++){
            System.out.println(patrons.get(i).getName());
        }

        List<Document> docs = librarian.docDao.getDocuments();
        System.out.println("Books:");
        for (int i = 0; i < docs.size(); i++) {
            if (docs.get(i).getClass().toString().equals("class net.proselyte.springsecurityapp.model.Documents.Book")) {
                System.out.println(docs.get(i).getTitle() + " " + docs.get(i).getCopies() + " copies");
            }
        }
        System.out.println("AVs:");
        for (int i = docs.size() - 5; i < docs.size(); i++) {
            if (docs.get(i).getClass().toString().equals("class net.proselyte.springsecurityapp.model.Documents.AudioVideo")) {
                System.out.println(docs.get(i).getTitle() + " " + docs.get(i).getCopies() + " copies");
            }
        }
    }

//    @Test
//    public static void clearDB(){
//        librarian.docDao.deleteLastBook();
//    }

    public static void main(String[] args) {
        b1 = new Book();
        b2 = new Book();
        b3 = new Book();

        av1 = new AudioVideo();
        av2 = new AudioVideo();

        p1 = new Patron();
        p2 = new Patron();
        p3 = new Patron();

        librarian = new Librarian();

        library = new Library();
        library.librarians.add(librarian);
        librarian.library = library;

        b1.setTitle("Introduction to Algorithms");
        b1.setAuthor("Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and Clifford Stein");
        b1.setYear("2009");
        b1.setEdition(3);
        b1.setBestSeller(false);
        b1.setCopies(3);
        b1.setKeys("NA");

        b2.setTitle("Design Patterns: Elements of Reusable Object-Oriented Software");
        b2.setAuthor("Erich Gamma, Ralph Johnson, John Vlissides, Richard Helm");
        b2.setYear("2003");
        b2.setEdition(1);
        b2.setBestSeller(true);
        b2.setCopies(2);
        b2.setKeys("NA");

        b3.setTitle("The Mythical Man-month");
        b3.setAuthor("Brooks,Jr., Frederick P.");
        b3.setYear("1995");
        b3.setEdition(2);
        b3.setCopies(1);
        b3.setBestSeller(false);
        b3.setKeys("reference");

        av1.setTitle("Null References: The Billion Dollar Mistake");
        av1.setAuthors("Tony Hoare");
        av1.setKeys("NA");


        av2.setTitle("Information Entropy");
        av2.setAuthors("Claude Shannon");
        av2.setKeys("NA");

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

        p3.setName("Elvira Espindola");
        p3.setAddress("Via del Corso, 22");
        p3.setPhone("30003");
        p3.setId((long) 1100);
        p3.setType("Student");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number from 1 to 9 (number of test case which you want to run). If you want to run test case #9 at first run tets case 1 re-run program and run test case 9");
        String num = scanner.next();
        switch (num) {
            case "1": testCase1(); break;
            case "2": testCase2(); break;
            case "3": testCase3(); break;
            case "4": testCase4(); break;
            case "5": testCase5(); break;
            case "6": testCase6(); break;
            case "7": testCase7(); break;
            case "8": testCase8(); break;
            case "9": testCase9(); break;
            default:
                System.out.println("Invalid number");
        }
    }
}
