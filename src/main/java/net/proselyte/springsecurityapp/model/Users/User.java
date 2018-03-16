package net.proselyte.springsecurityapp.model.Users;

import net.proselyte.springsecurityapp.model.Documents.Role;

import javax.persistence.*;
import java.util.Set;

/**
 * Simple JavaBean domain object that represents a User.
 *
 * @author Igor Vakhula
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Transient
    private String confirmPassword;

    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
        assert (this.id.equals(this.getId()));
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        assert (this.username.equals(this.getUsername()));
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        assert (this.password.equals(this.getPassword()));
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        assert (this.confirmPassword.equals(this.getConfirmPassword()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        assert (this.name.equals(this.getName()));
    }

    public String getSurname() { return surname; }

    public void setSurname(String surname) {
        this.surname = surname;
        assert (this.surname.equals(this.getSurname()));
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        assert (this.phone.equals(this.getPhone()));
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        assert (this.email.equals(this.getEmail()));
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
        assert (this.roles.equals(this.getRoles()));
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +

                '}';
    }
}
