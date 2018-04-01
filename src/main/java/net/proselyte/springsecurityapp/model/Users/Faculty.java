package net.proselyte.springsecurityapp.model.Users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Faculty")
public class Faculty extends Patron {

    public Faculty() {
    }

    public Faculty(String username, String password, String name, String surname, String phone, String email, String type, String address) {
        super(username, password, name, surname, phone, email, type, address);
    }
}
