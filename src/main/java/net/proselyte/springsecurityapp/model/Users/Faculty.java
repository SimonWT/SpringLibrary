package net.proselyte.springsecurityapp.model.Users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

public class Faculty extends Patron {
    public Faculty(String username, String password, String name, String surname, String phone, String email) {
        super(username, password, name, surname, phone, email);
    }
}