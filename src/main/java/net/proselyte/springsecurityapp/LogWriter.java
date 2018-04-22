package net.proselyte.springsecurityapp;

import net.proselyte.springsecurityapp.model.Documents.Article;
import net.proselyte.springsecurityapp.model.Documents.AudioVideo;
import net.proselyte.springsecurityapp.model.Documents.Book;
import net.proselyte.springsecurityapp.model.Documents.Document;
import net.proselyte.springsecurityapp.model.Users.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;

public class LogWriter {
    private Writer writer;

    public LogWriter() {
        try {
            this.writer = new FileWriter("log.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(User user, String action, Document document, User userOp) {
        String data = info(user, action, document, userOp);


        try {
            File file = new File("C:\\Users\\simon" +
                    "\\Documents\\Materals\\Projects & etc\\" +
                    "ITP II\\17.4.18\\SpringLibrary\\src\\main\\java" +
                    "\\net\\proselyte\\springsecurityapp\\log.txt");

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String read(){
        String result="nihuya";
        try {
            String file = "C:\\Users\\simon" +
                    "\\Documents\\Materals\\Projects & etc\\" +
                    "ITP II\\17.4.18\\SpringLibrary\\src\\main\\java" +
                    "\\net\\proselyte\\springsecurityapp\\log.txt";

            result = readUsingFiles(file);

        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }

    private static String readUsingFiles(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    private String info(User user, String action, Document document, User userOP) {
        String time = "[" + (new Date(System.currentTimeMillis())).toString().substring(4, 19) + "]";
        String userS = " (" + user.getType() + ") " + user.getUsername() +"[ "+user.getId()+" ] "+ ": ";
        String userOps = " ";
        String docS = "";
        if (document != null){
            String type = "Document";
            if (document instanceof Book) type = "Book";
            else if (document instanceof AudioVideo) type = "AV material";
            else if (document instanceof Article) type = "Article";
            docS = " "+type +" " +"[ "+document.getId()+" , "+document.getTitle() +" ] ";
        }
        else if (userOP != null) {
            String userType = "User";

            userOps = " " + getStringUserType(userOP) + " [ " + userOP.getId() + " , " + userOP.getUsername() + " ] ";
        }
        return time + userS +" "+ action +" " + docS + userOps + "\n";
    }

    private String getStringUserType(User user){
        String type = "User";
        if (user instanceof Librarian) type = "Librarian";
        else if (user instanceof Student) type = "Student";
        else if (user instanceof TA) type = "TA";
        else if (user instanceof Instructor) type = "Instructor";
        else if (user instanceof Professor) type = "Professor";
        else if (user instanceof VisitingProfessor) type = "VisitingProfessor";
        else if (user instanceof Faculty) type = "Faculty";
        else if (user instanceof Patron) type = "Patron";
        return type;
    }

}
