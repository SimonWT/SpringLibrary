package net.proselyte.springsecurityapp.dao.ForTesting;

import net.proselyte.springsecurityapp.model.Documents.AudioVideo;
import net.proselyte.springsecurityapp.model.Documents.Book;
import net.proselyte.springsecurityapp.model.Documents.Document;
import net.proselyte.springsecurityapp.model.Users.Librarian;
import net.proselyte.springsecurityapp.model.Users.Patron;
import net.proselyte.springsecurityapp.model.Users.User;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DocDaoImpl implements DocDao {

    private final Connection connection;

    public DocDaoImpl(){
        this.connection = getConnection();
    }

    private Connection getConnection(){
        try{
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://eu-cdbr-west-02.cleardb.net:3306/heroku_f76d6fb9e659782");
            dataSource.setUsername("baff532465d8d9");
            dataSource.setPassword("ffa9cd9f");
            Connection conn= DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());

            return conn;
        }catch (SQLException sqlerr){
            sqlerr.printStackTrace();
        }
        return null;
    }


    @Override
    public void addAV(AudioVideo av) {

        String sql = "INSERT INTO audio_video (author, title, price, copies) VALUE ('"
                +av.getAuthors()+
                "','"+av.getTitle()+
                "','"+av.getPrice()+
                "','"+av.getCopies()+
                "')"; //SQL Query

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
    public void addBook(Book book) {

        String sql = "INSERT INTO books (title, author, year, edition, price, copies) VALUE ('"
               +book.getTitle()+
                "','"+book.getAuthor()+"','"+book.getYear()+"','"+book.getEdition()+ "','"+book.getPrice()+
                "','"+book.getCopies()+"')"; //SQL Query

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
    public List<Document> getDocuments() {
        String sql = "SELECT id, author, title, year, edition,copies,price FROM books"; //SQL Query
        String sql2="SELECT id, author, title, price, copies FROM audio_video"; //SQL Query 2

        List<Document> list = new ArrayList<>();
        Book book=null;
        AudioVideo av=null;

        Statement stmt= null;
        try {
            stmt = connection.createStatement();
            ResultSet rs=stmt.executeQuery(sql);

            while(rs.next()) {
                //rs.next();
                book = new Book(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("year"),
                        rs.getInt("edition"),
                        rs.getInt("price"),
                        rs.getInt("copies")
                );

                //TODO: GetDocument to Every Patron
                list.add(book);
            }




            stmt = connection.createStatement();
            rs=stmt.executeQuery(sql2);

            while(rs.next()){
                av = new AudioVideo(
                        rs.getString("author"),
                        rs.getString("title"),
                        rs.getInt("price"),
                        rs.getInt("copies")
                );
                av.setId( rs.getLong("id"));
                list.add(av);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }





        return list;
    }

    @Override
    public void deleteLastBook() {
        //String sql = "with x(dummy) as (select top (1) null from books order by id desc) DELETE from x";
        String sql = "DELETE FROM books WHERE id = (SELECT x.id FROM (SELECT MAX(t.id) AS id FROM `books` t) x)";

        Statement stmt=null;
        try {

            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLastAV() {
        String sql = "DELETE FROM audio_video WHERE id = (SELECT x.id FROM (SELECT MAX(t.id) AS id FROM `audio_video` t) x)";

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
