package net.proselyte.springsecurityapp.model.Users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FACULTY")
public class Faculty extends Patron {
}
