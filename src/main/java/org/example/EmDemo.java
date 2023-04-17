package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Student student1=new Student();
        student1.setId(14134);
        student1.setName("Ranjeet More");
        student1.setCity("Pune");

        Certificate certificate=new Certificate();
        certificate.setCourse("Android");
        certificate.setDuration("2 Months");

        student1.setCert(certificate);

        Student student2=new Student();
        student2.setId(1212);
        student2.setName("Madhura More");
        student2.setCity("Pune");

        Certificate certificate1=new Certificate();
        certificate1.setCourse("Java");
        certificate1.setDuration("5 Months");

        student1.setCert(certificate1);

        Session s=factory.openSession();
        Transaction tx=s.beginTransaction();


        s.save(student1);
        s.save(student2);

        tx.commit();
        s.close();


        factory.close();
    }
}
