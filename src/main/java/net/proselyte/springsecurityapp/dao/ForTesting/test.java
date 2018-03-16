package net.proselyte.springsecurityapp.dao.ForTesting;

import net.proselyte.springsecurityapp.model.Documents.AudioVideo;
import net.proselyte.springsecurityapp.model.Documents.Book;
import net.proselyte.springsecurityapp.model.Documents.Document;
import net.proselyte.springsecurityapp.model.Users.Patron;

import java.util.List;

public class test {
    public static UserDao userDao = new UserDaoImpl();
    public static DocDao docDao = new DocDaoImpl();


    public static void main(String[] args){
//        Patron patr = new Patron("p1","p1","p1","p1","88888888","p1@innopolis.ru");
//        userDao.addUser(patr);
//        List<Patron> listOfPatrons = userDao.getPatrons();
//        for(Patron patron: listOfPatrons)
//            System.out.println(patron.getUsername());
//
        AudioVideo av = new AudioVideo("av1","av1",69,69);
        System.out.println(av.getAuthor());
        docDao.addAV(av);
//
//        List<Document> list = docDao.getDocuments();
//        for(int i =0; i< list.size(); i++)
//            System.out.println(list.get(i).getTitle());

        Book book = new Book((long) 69,"DD","DD","DD",323,3,3);
        docDao.addBook(book);
        docDao.deleteLastBook();


    }





}
