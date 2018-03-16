package net.proselyte.springsecurityapp.model.Users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


public class Student extends Patron {
    public Student(String username, String password, String name, String surname, String phone, String email) {
        super(username, password, name, surname, phone, email);
    }
}
