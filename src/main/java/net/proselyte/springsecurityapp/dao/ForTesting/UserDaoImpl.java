package net.proselyte.springsecurityapp.dao.ForTesting;

import net.proselyte.springsecurityapp.model.Users.User;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.*;

public class UserDaoImpl implements UserDao {

    private Connection connection;

   

    private void getConnection() throws SQLException {
        User user = getUserById(13L);
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://eu-cdbr-west-02.cleardb.net:3306/heroku_f76d6fb9e659782");
        dataSource.setUsername("baff532465d8d9");
        dataSource.setPassword("ffa9cd9f");
        String query="SELECT books.* FROM user_books INNER JOIN books ON user_books.book_id = books.id WHERE user_books.user_id=user.id";
        Connection conn= null;
        try {
            conn = DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(query);
        /*while(rs.next())
        {

        }*/
    }

        @Override
    public void addUser(User user) {

    }

    @Override
    public User getUserById(Long id) {

        return null;
    }
}
