package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.model.Users.Patron;

import java.util.Comparator;

public class PatronComparator implements Comparator<Patron> {

    @Override
    public int compare(Patron p1, Patron p2) {
        if (p1.getType().equals(p2.getType())){
            return 0;
        }
        else if (p1.getType().equals("Student")){
            return -1;
        }
        else if (p2.getType().equals("Student")){
            return 1;
        }
        else if (p1.getType().equals("Visiting Professor")){
            return -1;
        }
        else if (p2.getType().equals("Visiting Professor")){
            return 1;
        }
        else if (p1.getType().equals("Instructor")){
            return -1;
        }
        else if (p2.getType().equals("Instructor")){
            return 1;
        }
        else if (p1.getType().equals("TA")){
            return -1;
        }
        else if (p2.getType().equals("TA")){
            return 1;
        }
        else if (p1.getType().equals("Professor")){
            return -1;
        }
        else if (p2.getType().equals("Professor")){
            return 1;
        }
        return 0;
    }
}
