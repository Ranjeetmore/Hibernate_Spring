package com.pagination;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLPagination {
    public static void main(String[] args) {

        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Session s=factory.openSession();
        Query<Student> query= s.createQuery("from Student");
        query.setFirstResult(3);
        query.setMaxResults(5);
        List<Student> list=query.list();
        for (Student st:list)
        {
            System.out.println(st.getId()+" :"+st.getName()+" : "+st.getCity());
        }

        s.close();
        factory.close();
    }
}
