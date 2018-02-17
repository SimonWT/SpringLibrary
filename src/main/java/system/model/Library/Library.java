package system.model.Library;

import system.model.Users.Librarian;
import system.model.Users.Patron;

import java.util.ArrayList;

/**
 * Created by evgeniy on 13.02.18.
 */
public class Library {
    private Librarian librarian;
    private ArrayList<Patron> patrons;

    public Library(){
        librarian = new Librarian();
        patrons = new ArrayList<Patron>();
    }


}
