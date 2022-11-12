package com.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )throws IOException
    {
        //System.out.println( "Hello World!" );

        /*If hibernate.cfg.xml is not detected automatically by the class then we have to put it's name in
        configure() method of Configuration class.*/
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        System.out.println(sessionFactory);
        /*to check if session is closed or not*/
        System.out.println(sessionFactory.isClosed());

        /*1. Create the Entity object which data you want to save in a table*/
        Student student = new Student(103,"Anjali","Delhi");

        Address address = new Address();
        address.setStreet("street1");
        address.setCity("noida");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(123.34);

        FileInputStream fis = new FileInputStream("src/main/resources/feature1-img.png");
        byte[]  data = new byte[fis.available()];
        fis.read(data);
        address.setImage(data);
        /*2. Now to save this object in the table, we need to call save() method
         * which is in Session class. We can get the current Session using SessionFactory's getCurrentSession()
         * method.*/
        //If you are using first time session, call openSession(),for 2nd time , you can use getCurrentSession()
        Session session = sessionFactory.openSession();

        //Session session = sessionFactory.getCurrentSession();

        /*3. Begin the Transaction*/
        Transaction tx = session.beginTransaction();

        /*4. Save our Entity object data into the table*/
        session.save(student);
        session.save(address);


        /*5. To make the changes physically or permanent in tables, we need to commit the transaction.*/
        tx.commit();


        /*6. close the session*/
        session.close();

        sessionFactory.close();
    }
}
