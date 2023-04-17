package com.cascade;

import com.map.Answer;
import com.map.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CascadeExample {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Session s=factory.openSession();
        Question q1=new Question();
        q1.setQuestionId(569);
        q1.setQuestion("What is Spring framework?");

        Answer a1=new Answer(24, "In Spring  it is important");
        Answer a2=new Answer(25, "last answer");
        Answer a3=new Answer(26,"second last Answer");

        List<Answer> list=new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        q1.setAnswer(list);
        Transaction tx=s.beginTransaction();
        s.save(q1);
        s.save(a1);
        s.save(a2);
        s.save(a3);


        tx.commit();


        s.close();
        factory.close();
    }
}
