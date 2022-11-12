package com.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddedDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
       Certificate  certificate1 = new Certificate("hibernate","1 week");
       Certificate  certificate2 = new Certificate("JPA","2 week");

        Student student1 = new Student(123,"Ankit","Delhi");
        Student student2 = new Student(321,"Abhi","UP");

       student1.setCertificate(certificate1);
       student2.setCertificate(certificate2);
        Session session = sessionFactory.openSession();

        /*begin transaction*/
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);

        tx.commit(); //commit transaction
        session.close();
        sessionFactory.close();
    }
}
