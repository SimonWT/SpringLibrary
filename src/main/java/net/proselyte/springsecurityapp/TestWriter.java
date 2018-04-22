package net.proselyte.springsecurityapp;

import net.proselyte.springsecurityapp.model.Users.Student;
import sun.rmi.runtime.Log;

public class TestWriter {
    public static void main(String[] args){
        LogWriter log = new LogWriter();
        Student student = new Student("Petya","soska", "Petya",
                "Novoselov", "8805553554637", "soska@mail.ru",
                "Student", "keksa" );
//        log.write(student, "write", null, null);
//        log.write(student, "write", null, null);
        System.out.println(log.read());
    }
}
