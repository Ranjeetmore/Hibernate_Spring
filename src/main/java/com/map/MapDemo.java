package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MapDemo {
    public static void main(String[] args) {

        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        //creating question
        Question q1=new Question();
        q1.setQuestionId(1212);
        q1.setQuestion("What is Java?");

        //creating answer
        Answer answer=new Answer();
        answer.setAnswerId(343);
        answer.setAnswer("Java is a programming language");
        answer.setQ(q1);

        Answer answer1=new Answer();
        answer1.setAnswerId(344);
        answer1.setAnswer("With yhe help of java we can create softwares");
        answer1.setQ(q1);

        Answer answer2=new Answer();
        answer2.setAnswerId(345);
        answer2.setAnswer("Java has different type of frameworks");
        answer2.setQ(q1);

        List<Answer> list=new ArrayList<>();

        list.add(answer);
        list.add(answer1);
        list.add(answer2);

        q1.setAnswer(list);

        Session s=factory.openSession();
        Transaction tx=s.beginTransaction();

        s.save(q1);
        s.save(answer);
        s.save(answer1);
        s.save(answer2);



        tx.commit();

        Question newq=(Question)s.get(Question.class, 1212);
        System.out.println(newq.getQuestion());
        for (Answer a: newq.getAnswer())
        {
            System.out.println(a.getAnswer());
        }
        s.close();

        factory.close();
    }
}
