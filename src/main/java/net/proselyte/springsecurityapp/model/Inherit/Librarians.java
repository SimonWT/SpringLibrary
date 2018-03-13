package net.proselyte.springsecurityapp.model.Inherit;

import javax.persistence.*;

@Entity
@DiscriminatorValue("LIBRARIAN")
public class Librarians extends Users {

}
