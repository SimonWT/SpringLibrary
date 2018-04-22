package net.proselyte.springsecurityapp.model.Users;
import net.proselyte.springsecurityapp.LogWriter;
import net.proselyte.springsecurityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.io.IOException;

@Entity
@Component
@DiscriminatorValue("Admin")
public class Admin extends User{

    @Transient
    private LogWriter log = new LogWriter();

    public Admin() throws IOException {
    }

    public void addLibrarian(Librarian librarian) throws IOException {
        userService.save(librarian);
        log.write(this, "register new" , null,
                librarian);
    }

    public void deleteLibrarian(Librarian librarian) throws IOException {
        userService.delete(librarian.getId());
        log.write(this, "delete" , null,
                librarian);

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
