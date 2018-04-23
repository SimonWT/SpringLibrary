package net.proselyte.springsecurityapp;

import net.proselyte.springsecurityapp.config.jp;
import net.proselyte.springsecurityapp.dao.UserDao;
import net.proselyte.springsecurityapp.model.Documents.AudioVideo;
import net.proselyte.springsecurityapp.model.Documents.Book;
import net.proselyte.springsecurityapp.model.Users.*;
import net.proselyte.springsecurityapp.service.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {jp.class,UserServiceImpl.class,DocumentServiceImpl.class,HistoryServiceImpl.class, BCryptPasswordEncoder.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
@WebAppConfiguration
public class TestCases_23_04 {

    @Autowired
    protected UserServiceImpl userService;

    @Autowired
    protected DocumentServiceImpl documentService;

    @Autowired
    protected HistoryServiceImpl historyService;

    @Resource
    private UserDao userRepository;

    Admin admin;
    Librarian l;
    Professor p1, p2, p3;
    Student s;
    VisitingProfessor v;

    Book d1, d2;
    AudioVideo d3;

    DateFormat format;

    @Before
    public void createItems() throws IOException {

    }

    @Test
    public void testUnit(){

    }

    @Test
    public void testCase1(){

    }


}