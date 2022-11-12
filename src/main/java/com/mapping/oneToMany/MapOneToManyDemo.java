package com.mapping.oneToMany;


import com.mapping.oneToOne.Answer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapOneToManyDemo {
    public static void main(String[] args)throws IOException {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        OneQuestion q1 = new OneQuestion();
        q1.setQuestionId(1213);
        q1.setQuestion("what is Java");

        ManyAnswer ans1 = new ManyAnswer();
        ans1.setAnswerId(350);
        ans1.setAnswer("Java is a programming language.");
        ans1.setQuestion(q1);

        ManyAnswer ans2 = new ManyAnswer();
        ans2.setAnswerId(351);
        ans2.setAnswer("With the help of Java we can create softwares.");
        ans2.setQuestion(q1);

        ManyAnswer ans3 = new ManyAnswer();
        ans3.setAnswerId(352);
        ans3.setAnswer("Java has different types of framework.");
        ans3.setQuestion(q1);

        List<ManyAnswer> answers = new ArrayList<>();
        answers.add(ans1);
        answers.add(ans2);
        answers.add(ans3);

        q1.setAnswer(answers);



        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(q1);
        session.save(ans1);
        session.save(ans2);
        session.save(ans3);


        tx.commit();

        //fetching the Question object from the session
        OneQuestion question= (OneQuestion) session.get(OneQuestion.class,1212);
        System.out.println(question.getQuestion());

        for(ManyAnswer  answer : question.getAnswer()){
            System.out.println(answer.getAnswer());
        }


        session.close();
        sessionFactory.close();
    }
}
