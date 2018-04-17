package net.proselyte.springsecurityapp.model.Users;
import net.proselyte.springsecurityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@Component
@DiscriminatorValue("Admin")
public class Admin extends User{

    public void addLibrarian(Librarian librarian){
        userService.save(librarian);
    }

    public void deleteLibrarian(Librarian librarian){
        userService.delete(librarian.getId());
    }

    public Librarian getLibrarian(Long id){
        return (Librarian) userService.getUserById(id);
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


}
