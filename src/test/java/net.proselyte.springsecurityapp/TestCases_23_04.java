package net.proselyte.springsecurityapp;

import net.proselyte.springsecurityapp.config.jp;
import net.proselyte.springsecurityapp.dao.UserDao;
import net.proselyte.springsecurityapp.model.Booking.Queue;
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
@ContextConfiguration(classes = {jp.class,UserServiceImpl.class,DocumentServiceImpl.class,HistoryServiceImpl.class, QueueServiceImpl.class, BCryptPasswordEncoder.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
@WebAppConfiguration
public class TestCases_23_04 {

    @Autowired
    protected UserServiceImpl userService;

    @Autowired
    protected DocumentServiceImpl documentService;


    @Autowired
    protected HistoryServiceImpl historyService;

    @Autowired
    protected QueueService queueService;

    @Resource
    private UserDao userRepository;

    Admin admin;
    Librarian l1, l2, l3;
    Professor p1, p2, p3;
    Student s;
    VisitingProfessor v;

    Book d1, d2, d3;

    DateFormat format;

    @Before
    public void createItems() throws IOException {
        format = new SimpleDateFormat("dd MMM", Locale.ENGLISH);

        admin = new Admin();
        admin.setName("Eugenia");
        admin.setSurname("Rama");
        admin.setPhone("14837");
        admin.setId((long) 0);
        admin.setType("Librarian");
        admin.setEmail("esdfghjjgtbllnbnbnbgnzz");
        admin.setUsername("dfghjkl,fgllhjkxx");
        admin.setPassword("$2a$11$KaBxQDYikh.EWsYw5Bo0B.6G7FYWZN2rVdelaZWT6.zDHXwlJCju6");
        admin.setConfirmPassword("$2a$11$KaBxQDYikh.EWsYw5Bo0B.6G7FYWZN2rVdelaZWT6.zDHXwlJCju6");
        admin.userService = userService;

        l1 = new Librarian();
        l1.setName("Eugenia");
        l1.setSurname("Rama");
        l1.setPhone("14837");
        l1.setId((long) 1111);
        l1.setType("Librarian");
        l1.setEmail("esdfghjjgtbnbnbnbgnzz");
        l1.setUsername("dfghjkl,fghjkxx");
        l1.setPassword("$2a$11$KaBxQDYikh.EWsYw5Bo0B.6G7FYWZN2rVdelaZWT6.zDHXwlJCju6");
        l1.setConfirmPassword("$2a$11$KaBxQDYikh.EWsYw5Bo0B.6G7FYWZN2rVdelaZWT6.zDHXwlJCju6");
        l1.userService = userService;
        l1.docService = documentService;
        userService.save(l1);
        l1.historyService = historyService;
        l1.setPrivilege(1);

        l2 = new Librarian();
        l2.setName("Luie");
        l2.setSurname("Ramos");
        l2.setPhone("14837");
        l2.setId((long) 2222);
        l2.setType("Librarian");
        l2.setEmail("esdfghjjgtbnabnbnbgnzz");
        l2.setUsername("dfghjkl,fghjkzxx");
        l2.setPassword("$2a$11$KaBxQDYikh.EWsYw5Bo0B.6G7FYWZN2rVdelaZWT6.zDHXwlJCju6");
        l2.setConfirmPassword("$2a$11$KaBxQDYikh.EWsYw5Bo0B.6G7FYWZN2rVdelaZWT6.zDHXwlJCju6");
        l2.userService = userService;
        l2.docService = documentService;
        userService.save(l2);
        l2.historyService = historyService;
        l2.setPrivilege(2);

        l3 = new Librarian();
        l3.setName("Ramon");
        l3.setSurname("Valdez");
        l3.setPhone("14837");
        l3.setId((long) 3333);
        l3.setType("Librarian");
        l3.setEmail("esdfghjjgtbnbnbnblkgnzz");
        l3.setUsername("dfghjkl,fghjzzkxx");
        l3.setPassword("$2a$11$KaBxQDYikh.EWsYw5Bo0B.6G7FYWZN2rVdelaZWT6.zDHXwlJCju6");
        l3.setConfirmPassword("$2a$11$KaBxQDYikh.EWsYw5Bo0B.6G7FYWZN2rVdelaZWT6.zDHXwlJCju6");
        l3.userService = userService;
        l3.docService = documentService;
        userService.save(l3);
        l3.historyService = historyService;
        l3.setPrivilege(3);

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
        p1.setUserService(userService);
        p1.setHistoryService(historyService);
        p1.setDocumentService(documentService);
        p1.setQueueService(queueService);

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
        p2.setUserService(userService);
        p2.setHistoryService(historyService);
        p2.setDocumentService(documentService);
        p2.setQueueService(queueService);

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
        p3.setUserService(userService);
        p3.setHistoryService(historyService);
        p3.setDocumentService(documentService);
        p3.setQueueService(queueService);

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
        s.setUserService(userService);
        s.setHistoryService(historyService);
        s.setDocumentService(documentService);
        s.setQueueService(queueService);

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
        v.setUserService(userService);
        v.setHistoryService(historyService);
        v.setDocumentService(documentService);
        v.setQueueService(queueService);

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
        d1.setCopies(0);
        d1.setKeys("Algorithms Data Structures Complexity Computational Theory");

        d2 = new Book();
        d2.setTitle("Algorithms + Data Structures = Programs");
        d2.setAuthors("Niklaus Wirth");
        d2.setPublisher("Prentice Hall PTR");
        try {
            d2.setYear(format1.parse("01 1978"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        d2.setEdition(1);
        d2.setBestSeller(false);
        d2.setPrice(5000);
        d2.setCopies(0);
        d2.setKeys("Algorithms Data Structures Search Algorithms Pascal");

        d3 = new Book();
        d3.setTitle("The Art of Computer Programming");
        d3.setAuthors("Donald E. Knuth");
        d3.setPublisher("Addison Wesley Longman Publishing Co., Inc.");
        try {
            d3.setYear(format1.parse("01 1997"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        d3.setEdition(3);
        d3.setBestSeller(false);
        d3.setPrice(5000);
        d3.setCopies(0);
        d3.setKeys("Algorithms Combinatorial Algorithms Recursion");
    }

    @Test
    public void testUnit(){

    }

    @Test
    public void testCase2(){
        int oldLibrariansAmount = userService.getAllLibrarians().size();
        try {
            admin.addLibrarian(l1);
            admin.addLibrarian(l2);
            admin.addLibrarian(l3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(3, userService.getAllLibrarians().size() - oldLibrariansAmount);
    }

    @Test
    public void testCase3(){
        int oldDocAmount = documentService.getAllDocuments().size();
        try {
            admin.addLibrarian(l1);
            admin.addLibrarian(l2);
            admin.addLibrarian(l3);
            l1.addDoc(d1, 3);
            l1.addDoc(d2, 3);
            l1.addDoc(d3, 3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        l1.checkSysytem();
        assertEquals(0, documentService.getAllDocuments().size() - oldDocAmount);

    }

    @Test
    public void testCase4(){
        int oldDocAmount = documentService.getAllDocuments().size();
        int oldPatronsAmount = userService.getAllPatrons().size();
        try {
            admin.addLibrarian(l1);
            admin.addLibrarian(l2);
            admin.addLibrarian(l3);

            l2.addDoc(d1, 3);
            l2.addDoc(d2, 3);
            l2.addDoc(d3, 3);

            l2.addPatron(s);
            l2.addPatron(p1);
            l2.addPatron(p2);
            l2.addPatron(p3);
            l2.addPatron(v);
        } catch (IOException e) {
            e.printStackTrace();
        }
        l2.checkSysytem();
        assertEquals(5, userService.getAllPatrons().size() - oldPatronsAmount);
        assertEquals(3, documentService.getAllDocuments().size() - oldDocAmount);
    }

    @Test
    public void testCase5(){
        try {
            admin.addLibrarian(l1);
            admin.addLibrarian(l2);
            admin.addLibrarian(l3);

            l2.addDoc(d1, 3);
            l2.addDoc(d2, 3);
            l2.addDoc(d3, 3);

            l2.addPatron(s);
            l2.addPatron(p1);
            l2.addPatron(p2);
            l2.addPatron(p3);
            l2.addPatron(v);

            l3.removeDoc(d1, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        l2.checkSysytem();
        assertEquals(2, d1.getCopies());
    }

    @Test
    public void testCase6(){
         try {
            admin.addLibrarian(l1);
            admin.addLibrarian(l2);
            admin.addLibrarian(l3);

            l2.addDoc(d1, 3);
            l2.addDoc(d2, 3);
            l2.addDoc(d3, 3);

            l2.addPatron(s);
            l2.addPatron(p1);
            l2.addPatron(p2);
            l2.addPatron(p3);
            l2.addPatron(v);

            Date d = new Date();
            p1.checkout(d3, d);
            p2.checkout(d3, d);
            s.checkout(d3, d);
            v.checkout(d3, d);
            p3.checkout(d3, d);

            l1.outstandingRequest(d3, d);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertTrue(!d3.queue.isEmpty());
    }

    @Test
    public void testCase7(){
        try {
            admin.addLibrarian(l1);
            admin.addLibrarian(l2);
            admin.addLibrarian(l3);

            l2.addDoc(d1, 3);
            l2.addDoc(d2, 3);
            l2.addDoc(d3, 3);

            l2.addPatron(s);
            l2.addPatron(p1);
            l2.addPatron(p2);
            l2.addPatron(p3);
            l2.addPatron(v);

            Date d = new Date();
            p1.checkout(d3, d);
            p2.checkout(d3, d);
            s.checkout(d3, d);
            v.checkout(d3, d);
            p3.checkout(d3, d);

            l3.outstandingRequest(d3, d);

            assertTrue(d3.queue.isEmpty());
            assertEquals("You was removed from waiting list of document The Art of Computer Programming", v.getNotification());
            assertEquals("You was removed from waiting list of document The Art of Computer Programming", p3.getNotification());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testCase8(){
        try {
            admin.addLibrarian(l1);
            admin.addLibrarian(l2);
            admin.addLibrarian(l3);

            l2.addDoc(d1, 3);
            l2.addDoc(d2, 3);
            l2.addDoc(d3, 3);

            l2.addPatron(s);
            l2.addPatron(p1);
            l2.addPatron(p2);
            l2.addPatron(p3);
            l2.addPatron(v);

            Date d = new Date();
            p1.checkout(d3, d);
            p2.checkout(d3, d);
            s.checkout(d3, d);
            v.checkout(d3, d);
            p3.checkout(d3, d);

            l1.outstandingRequest(d3, d);

            BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
            bw.write(admin.getLog().toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}