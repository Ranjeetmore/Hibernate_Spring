package org.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");

        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        //creating student
        Student st=new Student();
        st.setId(108);
        st.setName("mhgfdf");
        st.setCity("avcd");
        System.out.println(st);




        //creating object of address class
        Address ad=new Address();
        ad.setStreet("Street1");
        ad.setCity("Delhi");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(10);
        FileInputStream fis=new FileInputStream("src/main/resources/sign.jpg");
        byte[] data=new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);






        Session session =factory.openSession();
        Transaction tx =session.beginTransaction();
        session.save(st);
        session.save(ad);
        tx.commit();
        session.close();
        System.out.println("Done");
        //System.out.println(factory.isClosed());
    }
}