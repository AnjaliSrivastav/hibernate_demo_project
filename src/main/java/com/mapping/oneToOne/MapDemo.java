package com.mapping.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

public class MapDemo {
    public static void main(String[] args)throws IOException {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Question q1 = new Question();
        q1.setQuestionId(1210);
        q1.setQuestion("what is Java");

        Answer ans = new Answer();
        ans.setAnswerId(348);
        ans.setAnswer("Java is a programming language.");
        ans.setQuestion(q1);

        q1.setAnswer(ans);

        Answer ans2 = new Answer(350,"Collection is an API to work with objects in Java");
        Question q2 = new Question(1217,"What is Collection Framework ?",ans2);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(ans);
        session.save(ans2);
        session.save(q1);
        session.save(q2);

        tx.commit();

        //fetching the Question object from the session
        Question question= (Question)session.get(Question.class,1212);
        System.out.println(question.getQuestion());
        System.out.println(question.getAnswer().getAnswer());

        session.close();
        sessionFactory.close();
    }
}
