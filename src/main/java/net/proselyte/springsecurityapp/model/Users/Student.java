package net.proselyte.springsecurityapp.model.Users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.IOException;

@Entity
@DiscriminatorValue("Student")
public class Student extends Patron {

    public Student(){
    }

    public Student(String username, String password, String name, String surname,
                   String phone, String email, String type, String address){
        super(username, password, name, surname, phone, email, type, address);
    }
}

