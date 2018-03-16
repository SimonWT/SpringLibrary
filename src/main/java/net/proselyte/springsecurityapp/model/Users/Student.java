package net.proselyte.springsecurityapp.model.Users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends Patron {
}
