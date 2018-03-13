package net.proselyte.springsecurityapp.model.Inherit;

import javax.persistence.*;

@Entity
@DiscriminatorValue("PATRON")
public class Patrons extends Users {

}
