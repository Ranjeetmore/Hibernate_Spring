package com.hql;

import org.example.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.awt.geom.QuadCurve2D;
import java.util.List;

public class HQLExample {
    public static void main(String[] args) {

        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session s=factory.openSession();
        //HQL syntax
        String query="from Student";

        Query q=s.createQuery(query);

        List<Student> list=q.list();

        for(Student student:list)
        {
            System.out.println(student.getName());
        }
        System.out.println("_________________________________________");

        Transaction tx= s.beginTransaction();

        Query query1=s.createQuery("delete from Student where city=:Atpadi");
        int r=query1.executeUpdate();
        System.out.println("Deleted:");
        System.out.println(r);
        tx.commit();

        s.close();
        factory.close();


    }
}
