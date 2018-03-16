package net.proselyte.springsecurityapp.model.Inherit;

import javax.persistence.*;

@Entity
@DiscriminatorValue("LIBRARIAN")
public class Librarians extends Users {
    public Librarians() {
    }

    public Librarians(String username, String name, String surname) {
        super(username, name, surname);
    }
}
