package net.proselyte.springsecurityapp.dao.ForTesting;

import javassist.bytecode.analysis.Executor;
import net.proselyte.springsecurityapp.model.Users.Librarian;
import net.proselyte.springsecurityapp.model.Users.Patron;
import net.proselyte.springsecurityapp.model.Users.User;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private final Connection connection;

    public UserDaoImpl(){
        this.connection = getConnection();
    }

    private Connection getConnection(){
        try{
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://eu-cdbr-west-02.cleardb.net:3306/heroku_f76d6fb9e659782");
            dataSource.setUsername("baff532465d8d9");
            dataSource.setPassword("ffa9cd9f");
            Connection conn=DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());

            return conn;
        }catch (SQLException sqlerr){
            sqlerr.printStackTrace();
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        String type=null;

        if(user instanceof Patron)
            type="PATRON";
        else if (user instanceof Librarian)
            type="LIBRARIAN";

        String sql = "INSERT INTO users (username, password, name, surname, phone, email, type) VALUE ('"+user.getUsername()+
                "','"+user.getPassword()+"','"+user.getName()+"','"+user.getSurname()+"','"+ user.getPhone()+"','"
                + user.getEmail()+"','"+type+"')"; //SQL Query

        Statement stmt= null;
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public User getUserById(Long id) {
        String sql = "SELECT id, name, surname, username, phone, email, type FROM users WHERE id='"+id+"')"; //SQL Query

        User user=null;

        Statement stmt= null;
        try {
            stmt = connection.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            rs.next();
            user = new User(rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("type"));
            user.setId(id);

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public List<Patron> getPatrons() {
        String sql = "SELECT id, name, surname, username, phone, email, type FROM users WHERE type='PATRON'"; //SQL Query
        List<Patron> list = new ArrayList<>();
        Patron patron=null;

        Statement stmt= null;
        try {
            stmt = connection.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()) {
                //rs.next();
                patron = new Patron(
                        rs.getString("username"),
                        "password",
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("type")
                );

                patron.setId(rs.getLong("id"));
                //TODO: GetDocument to Every Patron

                list.add(patron);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void deleteUser() {
        String sql = "DELETE FROM users WHERE id = (SELECT x.id FROM (SELECT MAX(t.id) AS id FROM `users` t) x)";

        Statement stmt=null;
        try {

            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
