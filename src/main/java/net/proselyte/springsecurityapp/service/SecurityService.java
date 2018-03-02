package net.proselyte.springsecurityapp.service;

/**
 * Service for Security.
 *
 * @author Igor Vakhula
 */

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
