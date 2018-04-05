package net.proselyte.springsecurityapp;

import net.proselyte.springsecurityapp.config.jp;
import net.proselyte.springsecurityapp.dao.UserDao;
import net.proselyte.springsecurityapp.model.Documents.AudioVideo;
import net.proselyte.springsecurityapp.model.Documents.Book;
import net.proselyte.springsecurityapp.model.Users.*;
import net.proselyte.springsecurityapp.service.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {jp.class,UserServiceImpl.class,DocumentServiceImpl.class,HistoryServiceImpl.class, BCryptPasswordEncoder.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
@WebAppConfiguration
public class TestCases_04_04 {

    @Autowired
    protected UserServiceImpl userService;

    @Autowired
    protected DocumentServiceImpl documentService;

    @Autowired
    protected HistoryServiceImpl historyService;

    @Resource
    private UserDao userRepository;

    Librarian l;
    Professor p1, p2, p3;
    Student s;
    VisitingProfessor v;

    Book d1, d2;
    AudioVideo d3;

    DateFormat format;

    @Before
    public void createItems(){
        format = new SimpleDateFormat("dd MMM", Locale.ENGLISH);

        l = new Librarian();
        l.setName("libr");
        l.setSurname("libr");
        l.setPhone("14837");
        l.setId((long) 0);
        l.setType("Librarian");
        l.setEmail("esdfghjjgtbnbnbnbgnzz");
        l.setUsername("dfghjkl,fghjkxx");
        l.setPassword("$2a$11$KaBxQDYikh.EWsYw5Bo0B.6G7FYWZN2rVdelaZWT6.zDHXwlJCju6");
        l.setConfirmPassword("$2a$11$KaBxQDYikh.EWsYw5Bo0B.6G7FYWZN2rVdelaZWT6.zDHXwlJCju6");
        l.userService = userService;
        l.docService = documentService;
        userService.save(l);
        l.historyService = historyService;

        p1 = new Professor();
        p1.setName("Sergey");
        p1.setSurname("Afonso");
        p1.setAddress("Via Margutta, 3");
        p1.setPhone("30001");
        p1.setId((long) 1010);
        p1.setType("Professor");
        p1.setEmail("esdfghjjgtbnbnbnbgn");
        p1.setUsername("dfghjkl,fghjk");
        p1.setPassword("$2a$11$KaBxQDYikh.EWsYw5Bo0B.6G7FYWZN2rVdelaZWT6.zDHXwlJCju6");
        p1.setConfirmPassword("$2a$11$KaBxQDYikh.EWsYw5Bo0B.6G7FYWZN2rVdelaZWT6.zDHXwlJCju6");

        p2 = new Professor();
        p2.setName("Nadia");
        p2.setSurname("Teixeira");
        p2.setUsername("dfghjkl,fghjks");
        p2.setAddress("Via Sacra, 13");
        p2.setPhone("30002");
        p2.setId((long) 1011);
        p2.setPassword("$2a$11$KaBxQDYikh.EWsYw5Bo0B.6G7FYWZN2rVdelaZWT6.zDHXwlJCju6");
        p2.setConfirmPassword("$2a$11$KaBxQDYikh.EWsYw5Bo0B.6G7FYWZN2rVdelaZWT6.zDHXwlJCju6");
        p2.setType("Professor");
        p2.setEmail("esdfghjjgtbnbnbgn");

        p3 = new Professor();
        p3.setName("Elvira");
        p3.setSurname("Espindola");
        p3.setAddress("Via del Corso, 22");
        p3.setPhone("30003");
        p3.setId((long) 1100);
        p3.setType("Professor");
        p3.setPassword("$2a$11$KaBxQDYikh.EWsYw5Bo0B.6G7FYWZN2rVdelaZWT6.zDHXwlJCju6");
        p3.setConfirmPassword("$2a$11$KaBxQDYikh.EWsYw5Bo0B.6G7FYWZN2rVdelaZWT6.zDHXwlJCju6");
        p3.setUsername("dfghjkl,fghjka");
        p3.setEmail("esdfghjjgtbnbnbnbn");

        s = new Student();
        s.setName("Andrey");
        s.setSurname("Velo");
        s.setAddress("Avenida Mazatlan 250");
        s.setPhone("30004");
        s.setId((long) 1101);
        s.setType("Student");
        s.setPassword("$2a$11$KaBxQDYikh.EWsYw5Bo0B.6G7FYWZN2rVdelaZWT6.zDHXwlJCju6");
        s.setConfirmPassword("$2a$11$KaBxQDYikh.EWsYw5Bo0B.6G7FYWZN2rVdelaZWT6.zDHXwlJCju6");
        s.setUsername("dfghjkl,fghjkaq");
        s.setEmail("esdfghjjgtbnbnbnbnqq");

        v = new VisitingProfessor();
        v.setName("Veronika");
        v.setSurname("Rama");
        v.setAddress("Stret Atocha, 27");
        v.setPhone("30005");
        v.setId((long) 1110);
        v.setType("Visiting Professor");
        v.setPassword("$2a$11$KaBxQDYikh.EWsYw5Bo0B.6G7FYWZN2rVdelaZWT6.zDHXwlJCju6");
        v.setConfirmPassword("$2a$11$KaBxQDYikh.EWsYw5Bo0B.6G7FYWZN2rVdelaZWT6.zDHXwlJCju6");
        v.setUsername("dfghjkl,fghjkaqppee");
        v.setEmail("esdfghjjgtbnbnbnbnqqppee");


        l.addPatron(p1);
        l.addPatron(p2);
        l.addPatron(p3);
        l.addPatron(s);
        l.addPatron(v);

        p1.setDocumentService(documentService);
        p1.setUserService(userService);
        p1.setHistoryService(historyService);

        p2.setDocumentService(documentService);
        p2.setUserService(userService);
        p2.setHistoryService(historyService);

        p3.setDocumentService(documentService);
        p3.setUserService(userService);
        p3.setHistoryService(historyService);

        s.setDocumentService(documentService);
        s.setUserService(userService);
        s.setHistoryService(historyService);

        v.setDocumentService(documentService);
        v.setUserService(userService);
        v.setHistoryService(historyService);

        DateFormat format1 = new SimpleDateFormat("mm yyyy");
        d1 = new Book();
        d1.setTitle("Intoduction to Algorithms");
        d1.setAuthors("Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and Clifford Stein");
        d1.setPublisher("MIT Press");
        try {
            d1.setYear(format1.parse("01 2009"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        d1.setEdition(3);
        d1.setBestSeller(false);
        d1.setPrice(5000);
        d1.setCopies(3);

        d2 = new Book();
        d2.setTitle("Design Patterns: Elements of Reusable Object-Oriented Software");
        d2.setAuthors("Erich Gamma, Ralph Johnson, John Vlissides, Richard Helm");
        d2.setPublisher("Addison-Wesley Professional");
        try {
            d2.setYear(format1.parse("01 2003"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        d2.setEdition(1);
        d2.setBestSeller(true);
        d2.setPrice(1700);
        d2.setCopies(3);

        d3 = new AudioVideo();
        d3.setTitle("Null References: The Billion Dollar Mistake");
        d3.setAuthors("Tony Hoare");
        d3.setPrice(700);
        d3.setCopies(2);

        l.addDoc(d1, d1.getCopies());
        l.addDoc(d2, d2.getCopies());
        l.addDoc(d3, d3.getCopies());
    }

    @Test
    public void testUnit(){
        User user = userService.findByUsername("Test");
        System.out.println(user);
    }

    @Test
    public void testCase1(){
        try {
            p1.checkout(d1, format.parse("05 March"));
            p1.checkout(d2, format.parse("05 March"));

            p1.toReturn(d2, format.parse("02 April"));

            String expectedResult = "Name: Sergey\n" +
                    "Address:Via Margutta, 3\n" +
                    "Phone:30001\n" +
                    "Id:1010\n" +
                    "Documents:\n" +
                    "\t Title: Intoduction to Algorithms 0 days overdue 0 roubles fine\n";
            assertEquals(expectedResult, l.checkOverdue(p1, format.parse("02 April")));
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testCase2(){
        Date date = new Date();
        try {
            date = format.parse("05 March");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        p1.checkout(d1, date);
        p1.checkout(d2, date);

        s.checkout(d1, date);
        s.checkout(d2, date);

        v.checkout(d1, date);
        v.checkout(d2, date);


        try {
            date = format.parse("02 April");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String expectedResult = "Name: Sergey\n" +
                "Address:Via Margutta, 3\n" +
                "Phone:30001\n" +
                "Id:1010\n" +
                "Documents:\n" +
                "\t Title: Intoduction to Algorithms 0 days overdue 0 roubles fine\n" +
                "\t Title: Design Patterns: Elements of Reusable Object-Oriented Software 0 days overdue 0 roubles fine\n" +
                "Name: Andrey\n" +
                "Address:Avenida Mazatlan 250\n" +
                "Phone:30004\n" +
                "Id:1101\n" +
                "Documents:\n" +
                "\t Title: Intoduction to Algorithms 7 days overdue 700 roubles fine\n" +
                "\t Title: Design Patterns: Elements of Reusable Object-Oriented Software 14 days overdue 1400 roubles fine\n" +
                "Name: Veronika\n" +
                "Address:Stret Atocha, 27\n" +
                "Phone:30005\n" +
                "Id:1110\n" +
                "Documents:\n" +
                "\t Title: Intoduction to Algorithms 21 days overdue 2100 roubles fine\n" +
                "\t Title: Design Patterns: Elements of Reusable Object-Oriented Software 21 days overdue 1700 roubles fine\n";
        assertEquals(expectedResult, l.checkOverdue(p1,date) + l.checkOverdue(s, date) + l.checkOverdue(v, date));

    }

    @Test
    public void testCase3(){
        Date date = new Date();

        try {
            date = format.parse("05 March");
            p1.checkout(d1, date);
            s.checkout(d2, date);
            v.checkout(d2, date);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        try {
            date = format.parse("02 April");
            p1.renew(d1, date);
            s.renew(d2, date);
            v.renew(d2, date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String expectedRes = "Name: Sergey\n" +
                "Address:Via Margutta, 3\n" +
                "Phone:30001\n" +
                "Id:1010\n" +
                "Documents:\n" +
                "\t Title: Intoduction to Algorithms Due date: Thu Apr 30 00:00:00 MSK 1970\n" +
                "Name: Andrey\n" +
                "Address:Avenida Mazatlan 250\n" +
                "Phone:30004\n" +
                "Id:1101\n" +
                "Documents:\n" +
                "\t Title: Design Patterns: Elements of Reusable Object-Oriented Software Due date: Thu Apr 16 00:00:00 MSK 1970\n" +
                "Name: Veronika\n" +
                "Address:Stret Atocha, 27\n" +
                "Phone:30005\n" +
                "Id:1110\n" +
                "Documents:\n" +
                "\t Title: Design Patterns: Elements of Reusable Object-Oriented Software Due date: Thu Apr 09 00:00:00 MSK 1970\n";
        assertEquals(expectedRes, l.checkInfo(p1) + l.checkInfo(s) + l.checkInfo(v));

    }

    @Test
    public void testCase4(){
        Date date = new Date();

        try {
            date = format.parse("05 March");
            p1.checkout(d1, date);
            s.checkout(d2, date);
            v.checkout(d2, date);

            date = format.parse("02 April");
            p1.renew(d1, date);
            s.renew(d2, date);
            v.renew(d2, date);

            l.outstandingrequest(d2, date);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
            bw.write(l.checkInfo(p1));
            bw.write(l.checkInfo(s));
            bw.write(l.checkInfo(v));
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testCase5(){
        p1.checkout(d3, new Date());
        s.checkout(d3, new Date());
        v.checkout(d3, new Date());
        assertEquals(v.getId(), (Long) l.checkQueue(d3)[0]);
    }

    @Test
    public void testCase6(){
        Date d = new Date(2018, 3, 5);
        p1.checkout(d3, d);
        p2.checkout(d3, d);
        s.checkout(d3, d);
        v.checkout(d3, d);
        p3.checkout(d3, d);
        long[] usersInQueue = l.checkQueue(d3);
        assertEquals(s.getId(), (Long) usersInQueue[0]);
        assertEquals(v.getId(), (Long) usersInQueue[1]);
        assertEquals(p3.getId(), (Long) usersInQueue[2]);
    }

    @Test
    public void testCase7(){
        Date d = new Date(2018, 3, 5);
        p1.checkout(d3, d);
        p2.checkout(d3, d);
        s.checkout(d3, d);
        v.checkout(d3, d);
        p3.checkout(d3, d);

        l.outstandingrequest(d3, new Date());

        assertTrue(d3.queue.isEmpty());
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
            bw.write(p1.getNotification() + p2.getNotification() + s.getNotification() + v.getNotification() + p3.getNotification());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCase8(){
        Date d = new Date(2018, 3, 5);
        p1.checkout(d3, d);
        p2.checkout(d3, d);
        s.checkout(d3, d);
        v.checkout(d3, d);
        p3.checkout(d3, d);
        p2.toReturn(d3, new Date());
        assertEquals("Document Null References: The Billion Dollar Mistake is available for you to checkout", s.getNotification());
        assertTrue(p2.getDocuments().isEmpty());
        long[] usersInQueue = l.checkQueue(d3);
        assertEquals(s.getId(), (Long) usersInQueue[0]);
        assertEquals(v.getId(), (Long) usersInQueue[1]);
        assertEquals(p3.getId(), (Long) usersInQueue[2]);
    }

    @Test
    public void testCase9(){
        Date d = new Date();
        try {
            d = format.parse("02 April");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        p1.checkout(d3, d);
        p2.checkout(d3, d);
        s.checkout(d3, d);
        v.checkout(d3, d);
        p3.checkout(d3, d);

        long[] usersInQueue = l.checkQueue(d3);
        assertEquals(s.getId(), (Long) usersInQueue[0]);
        assertEquals(v.getId(), (Long) usersInQueue[1]);
        assertEquals(p3.getId(), (Long) usersInQueue[2]);

        try {
            d = format.parse("16 April");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        p1.renew(d3, d);

        String patronInfoExp = "Name: Sergey\n" +
                "Address:Via Margutta, 3\n" +
                "Phone:30001\n" +
                "Id:1010\n" +
                "Documents:\n" +
                "\t Title: Null References: The Billion Dollar Mistake Due date: Thu Apr 30 00:00:00 MSK 1970\n";
        assertEquals(patronInfoExp, l.checkInfo(p1));

    }

    @Test
    public void testCase10(){

        Date date = new Date();

        try {
            date = format.parse("26 March");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        p1.checkout(d1, date);
        v.checkout(d1, date);

        try {
            date = format.parse("29 March");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        p1.renew(d1, date);
        v.renew(d1, date);

        p1.renew(d1, new Date());
        v.renew(d1, new Date());

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
            bw.write(l.checkInfo(p1));
            bw.write(l.checkInfo(v));
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}