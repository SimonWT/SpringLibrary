package net.proselyte.springsecurityapp.model.Users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Instructor")
public class Instructor extends Faculty {
    public Instructor() {
    }

    public Instructor(String username, String password, String name, String surname, String phone, String email, String type, String type1, String address) {
        super(username, password, name, surname, phone, email, type, type1, address);
    }
}
