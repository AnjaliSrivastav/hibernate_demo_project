package com.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        /*this example is for get() and load() method to fetch data*/
       Configuration configuration= new Configuration();
       configuration.configure();
       SessionFactory sessionFactory = configuration.buildSessionFactory();
       Session session = sessionFactory.openSession();

       /*Now we don't need Transaction here, it is only needed while saving the data. Here we are fetching
       * the data , SO, if we don't use Transaction, our job will be done.*/

       /*get() -> Student-102*/
        Student student1= (Student)session.get(Student.class,102);
        System.out.println(student1);

        /*If the object doesn't exist in db for the Id,get() will return null, while load will throw ObjectNotFoundException */
        Student student2= (Student)session.get(Student.class,104);
        System.out.println(student2);

        /*load will not hit database till line no. 27, bcz till that hibernate only create the proxy object and not return the object
        * */
        Address address= (Address)session.load(Address.class,1);



        System.out.println(address.getAddedDate()+" : "+address.getCity()); //at this line, hibernate will hit db, execute select query and return the object.


        session.close();
        sessionFactory.close();




    }
}
