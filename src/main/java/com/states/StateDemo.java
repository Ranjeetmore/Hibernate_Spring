package com.states;

import org.example.Certificate;
import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {
    public static void main(String[] args) {


        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        //Creating student object
        Student student=new Student();
        student.setId(1414);
        student.setName("Ranjeet");
        student.setCity("ABC");
        student.setCert(new Certificate("Java Hibernate", "2 months"));
        //student: Transient state

        Session s= factory.openSession();
        Transaction tx=s.beginTransaction();

        s.save(student);
        student.setName("Madhura");
        //student: Persistent state- session database

        tx.commit();
        s.close();
        //student: detached
        student.setName("Lata");
        System.out.println(student);

        factory.close();

    }
}
