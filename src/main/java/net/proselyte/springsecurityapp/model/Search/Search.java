package net.proselyte.springsecurityapp.model.Search;

import net.proselyte.springsecurityapp.model.Documents.Document;
import net.proselyte.springsecurityapp.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.print.Doc;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Search {

    @Autowired
    private DocumentService documentService;

    public Search() {

    }

    public List<Document> searchFull(String searchString){
        List<Document> documentsAnswerListBySearchString = new ArrayList<>();
        List<Document> documents = documentService.getAllDocuments();
        for (int i = 0; i < documents.size(); i++) {
            Document document = documents.get(i);
            if (document.getTitle().equals(searchString)) {
                documentsAnswerListBySearchString.add(document);
            }
        }
        return documentsAnswerListBySearchString;
    }

    public List<Document> searchPart(String searchString) throws SQLException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1/deep_library_3rd_delivery");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://eu-cdbr-west-02.cleardb.net:3306/heroku_f76d6fb9e659782");
//        dataSource.setUsername("baff532465d8d9");
//        dataSource.setPassword("ffa9cd9f");
        String query1="SELECT * FROM documents WHERE title regexp '[[:<:]]"+ searchString +"[[:>:]]'";

        Connection conn= DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(query1);
        List<Document> documentsAnswerListBySearchString = new LinkedList<>();
        while(rs.next()){
            String titlePart = rs.getString("title");
            String authorPart = rs.getString("authors");
            Integer pricePart = rs.getInt("price");
            Document document = new Document();
            document.setAuthors(authorPart);
            document.setTitle(titlePart);
            document.setPrice(pricePart);
            documentsAnswerListBySearchString.add(document);
        }
        return documentsAnswerListBySearchString;
    }

}
