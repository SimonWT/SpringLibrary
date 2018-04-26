package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.model.Documents.Document;
import net.proselyte.springsecurityapp.model.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@SuppressWarnings("ALL")
@Service
@PropertySource(value = {"classpath:application.properties"})
public class NotificationService {

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    private JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
    public void sendNotification(User user) throws MailException {
        //send email
        JavaMailSender javaMailSender = getJavaMailSender();
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom("innodeeplib@gmail.com");
        mail.setSubject("Deep Library");
        mail.setText("Welcome to our team");

        javaMailSender.send(mail);
    }

    public void sendNotificationBooking(User user, Document document) throws MailException {
        JavaMailSender javaMailSender = getJavaMailSender();
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom("innodeeplib@gmail.com");
        mail.setSubject("Deep Library");
        if (user.getType().equals("Student") || user.getType().equals("TA")) {
            mail.setText("You have just checked out the book and you should return it in 3 weeks." +
                    "Please be careful with " + document.getTitle() + ". Remeber that people will use it after you" +
                    "Thank you in advance");
        } else {
            mail.setText("You have just checked out the book and you should return it in 4 weeks." +
                    "Please be careful with"+ document.getTitle() +"Remeber that people will use it after you" +
                    "Thank you in advance");
        }
        javaMailSender.send(mail);
    }

    public void sendNotificationQueue(User user, Document document) throws MailException {
        JavaMailSender javaMailSender = getJavaMailSender();
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom("innodeeplib@gmail.com");
        mail.setSubject("Deep Library");
        mail.setText("You are in queue for book" + document.getTitle() + " which is written by" + document.getAuthors());
        javaMailSender.send(mail);
    }

    public void sendReturnQuery(User user, Document document) throws MailException {
        JavaMailSender javaMailSender = getJavaMailSender();
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom("innodeeplib@gmail.com");
        mail.setSubject("Deep Library");
        mail.setText("Please return the" + document.getTitle() + " which is written by" + document.getAuthors());
        javaMailSender.send(mail);
    }

}