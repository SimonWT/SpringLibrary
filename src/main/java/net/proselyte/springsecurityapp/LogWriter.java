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
import java.util.LinkedList;
import java.util.List;
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
            File file = new File("src\\main\\java\\net\\proselyte\\springsecurityapp\\log.txt");

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeAddition(User user, String action, Document document, User userOp, String addition){
        String data = info(user, action, document, userOp);

        try {
            File file = new File("src\\main\\java\\net\\proselyte\\springsecurityapp\\log.txt");

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.write(data+addition);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<String> read(){
        List<String> result= new LinkedList<>();

        String file = "src\\main\\java\\net\\proselyte\\springsecurityapp\\log.txt";

        //result = readUsingFiles(file);
        result = readLines(file);

        return result;
    }

    public void clean(){
        try {
            File file = new File("src\\main\\java\\net\\proselyte\\springsecurityapp\\log.txt");

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.write("");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readUsingFiles(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    private static List<String> readLines(String fileName){
        List<String> stringList = new LinkedList<>();
        try {
            Scanner sc = new Scanner(new FileReader(fileName));
            while(sc.hasNext()){
                stringList.add(sc.nextLine());
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return stringList;
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
