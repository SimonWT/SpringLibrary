package net.proselyte.springsecurityapp.model.Users;


import net.proselyte.springsecurityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Component;

@Component
public class Admin extends User{
    @Transient
    @Autowired
    public UserService userService;

    public void addLibrarian(Librarian librarian){
        userService.save(librarian);
    }

    public void deleteLibrarian(Librarian librarian){
        userService.delete(librarian.getId());
    }

    public Librarian getLibrarian(Long id){
        return (Librarian) userService.getUserById(id);
    }
}
