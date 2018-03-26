package net.proselyte.springsecurityapp.model.Users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TA")
public class TA extends Faculty {
    public TA() {
    }

    public TA(String username, String password, String name, String surname, String phone, String email) {
        super(username, password, name, surname, phone, email);
    }
}
