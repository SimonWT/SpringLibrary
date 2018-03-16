package net.proselyte.springsecurityapp.model.Inherit;

import javax.persistence.*;

@Entity
@DiscriminatorValue("PATRON")
public class Patrons extends Users {
    public Patrons() {
    }

    public Patrons(String username, String name, String surname) {
        super(username, name, surname);
    }
}
