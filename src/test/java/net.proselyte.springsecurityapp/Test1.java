package net.proselyte.springsecurityapp;

import net.proselyte.springsecurityapp.config.jp;
import net.proselyte.springsecurityapp.dao.UserDao;
import net.proselyte.springsecurityapp.model.Booking.History;
import net.proselyte.springsecurityapp.model.Users.User;
import net.proselyte.springsecurityapp.service.*;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {jp.class,UserServiceImpl.class,DocumentServiceImpl.class,HistoryServiceImpl.class, BCryptPasswordEncoder.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
@WebAppConfiguration
public class Test1 {

    @Autowired
    protected UserServiceImpl userService;

    @Autowired
    protected DocumentServiceImpl documentService;

    @Autowired
    protected HistoryServiceImpl historyService;

    @Resource
    private UserDao userRepository;

    public final long MARCH_5 = 1520222902225L;
    public final long MARCH_6 = 1520309302225L;
    public final long MARCH_7 = 1520309302225L+3600000*24;
    public final long MARCH_31 = 1522454441000L;
    public final long MARCH_28 = 1522195241000L;

    public static String getDate(long currentTime) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(currentTime);
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return format.format(cal.getTime());
    }

//    @Before
//    public void before(){
//        User p1 = new User("email1","pass","Sergey","Afonso", "cookieId1",
//                "ta",0,"Via Margutta, 3","30001");
//        userService.save(p1);
//        User p2 = new User("email2","pass","Nadia", "Teixeira","cookieId2",
//                "ta",0,"Via Sacra, 13","30002");
//        userService.save(p2);
//        User p3=new User("email3","pass","Elvira", "Espindola","cookieId3",
//                "ta",0,"Via del Corso, 22","30003");
//        userService.save(p3);
//        User s=new User("emails","pass","Andrey", "Velo","cookieIds",
//                "student",0,"Avenida Mazatlan 250","30004");
//        userService.save(s);
//        User v=new User("emailv","pass","Veronika" ,"Rama","cookieIdv",
//                "visitingProfessor",0,"Stret Atocha, 27","30005");
//        userService.save(v);
//
//        Document d1=new Document("Introduction to Algorithms",
//                "Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest and Clifford Stein",
//                "book",3,"5000","","book",2009,"MIT Press","Third edition",5000);
//
//        documentService.save(d1);
//
//        Document d2=new Document("Design Patterns: Elements of Reusable Object-Oriented Software",
//                "Erich Gamma, Ralph Johnson, John Vlissides, Richard Helm",
//                "bestseller",3,"1700","","book",2003,
//                "Addison-Wesley Professional","First edition",1700);
//        documentService.save(d2);
//
//        Document d3=new Document("Null References: The Billion Dollar Mistake",
//                "Tony Hoare","",2,"700","","",0,"","",700);
//        documentService.save(d3);
//        System.out.println(documentService.getAllDocuments());
//        System.out.println(orderServiceC.getAllOrders());
//        System.out.println(userService.getAllusers());
//
//    }
//
//    @org.junit.Test
//    public void t1() {
//
//        User p1 = userService.get(1);
//        Document d1 = documentService.get(1);
//        Document d2 = documentService.get(2);
//        userService.checkoutDocument(d1.getId(),p1.getId());
//        userService.checkoutDocument(d2.getId(),p1.getId());
//        assertEquals(2,orderServiceC.getAllOrders().size());
//        Order or1 = orderServiceC.getAllOrders().get(0);
//        Order or2 = orderServiceC.getAllOrders().get(1);
//        documentService.returnDocument(or1.getId());
//        assertEquals(0,or1.overdueDays());
//        assertEquals(0,orderServiceC.getFine(or1, d1));
//
//    }
//
//    @org.junit.Test
//    public void t2(){
//        User p1 = userService.get(1);
//        User s = userService.get(4);
//        User v = userService.get(5);
//        Document d1 = documentService.get(1);
//        Document d2 = documentService.get(2);
//        userService.checkoutDocument(d1.getId(),p1.getId());
//        userService.checkoutDocument(d2.getId(),p1.getId());
//        userService.checkoutDocument(d1.getId(),s.getId());
//        userService.checkoutDocument(d2.getId(),s.getId());
//        userService.checkoutDocument(d1.getId(),v.getId());
//        userService.checkoutDocument(d2.getId(),v.getId());
//        List<Order> orders = orderServiceC.getAllOrders();
//        for(Order or:orders){
//            or.setFinishTime(MARCH_7+or.getFinishTime()-or.getStartTime());
//            or.setStartTime(MARCH_7);
//            System.out.println(getDate(MARCH_7)+"-"+getDate(or.getFinishTime()));
//        }
//        System.out.println(orders);
//
//        System.out.println(orders.get(0).overdueDays());
//        assertEquals(0, orders.get(0).overdueDays());
//        assertEquals(0, orders.get(1).overdueDays());
//        assertEquals(6, orders.get(2).overdueDays());
//        assertEquals(13, orders.get(3).overdueDays());
//        assertEquals(20, orders.get(4).overdueDays());
//        assertEquals(20, orders.get(5).overdueDays());
//    }
//
//    @org.junit.Test
//    public void t3(){
//        User p1 = userService.get(1);
//        User s = userService.get(4);
//        User v = userService.get(5);
//        Document d1 = documentService.get(1);
//        Document d2 = documentService.get(2);
//        userService.checkoutDocument(d1.getId(),p1.getId());
//        userService.checkoutDocument(d2.getId(),s.getId());
//        userService.checkoutDocument(d2.getId(),v.getId());
//        List<Order> orders = orderServiceC.getAllOrders();
//        userService.renewDocument(orders.get(0).getId());
//        userService.renewDocument(orders.get(1).getId());
//        userService.renewDocument(orders.get(2).getId());
//
//        assertEquals("02.05.2018", getDate(orders.get(0).getFinishTime()));
//        assertEquals("18.04.2018", getDate(orders.get(1).getFinishTime()));
//        assertEquals("11.04.2018", getDate(orders.get(2).getFinishTime()));
//    }

    @org.junit.Test
    public void testUnit(){
        User user = userService.findByUsername("Test");
        System.out.println(user);
    }

   /* @org.springframework.context.annotation.Configuration
    public static class ContextConfiguration {
    }
    */
}