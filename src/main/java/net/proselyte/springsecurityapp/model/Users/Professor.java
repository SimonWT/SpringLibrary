package net.proselyte.springsecurityapp.model.Users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Professor")
public class Professor extends Faculty {

    public Professor() {
    }

    public Professor(String username, String password, String name, String surname, String phone, String email, String type) {
        super(username, password, name, surname, phone, email, type);
    }
}
