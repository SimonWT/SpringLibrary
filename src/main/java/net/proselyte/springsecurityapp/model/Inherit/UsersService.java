package net.proselyte.springsecurityapp.model.Inherit;

public interface UsersService {
    void save(Users user);
    Users getUsersById(Long id);
}
