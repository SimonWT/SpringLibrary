package net.proselyte.springsecurityapp.model.Tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestCases_04_04 {
    public static void main(String[] args){
        Date date = new Date(System.currentTimeMillis());
        DateFormat df = new SimpleDateFormat("yyyy");
        System.out.println(df.format(date));

    }
}
