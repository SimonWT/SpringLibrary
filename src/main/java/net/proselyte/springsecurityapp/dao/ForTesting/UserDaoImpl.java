package net.proselyte.springsecurityapp.dao.ForTesting;

import net.proselyte.springsecurityapp.model.Users.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private Connection connection;

    public UserDaoImpl(){
        this.connection = getConnection();
    }

    private Connection getConnection(){
        try{
            String DB_URL = "jdbc:mysql://eu-cdbr-west-02.cleardb.net:3306/heroku_f76d6fb9e659782";
            String USER = "baff532465d8d9";
            String PASS = "ffa9cd9f";

            return DriverManager.getConnection(DB_URL, USER, PASS);
        }catch (SQLException sqlerr){
            sqlerr.printStackTrace();
        }
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public User getUserById(Long id) {

        return null;
    }
}
