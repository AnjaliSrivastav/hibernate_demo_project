package com.mapping.manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MapManyToManyDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        /*here we are creating at least two objects of Employees and two objects of Project to show ManyToMany mapping. */
        Employee emp1 = new Employee();
        emp1.setEmpId(12);
        emp1.setEmpName("Ram");

        Employee emp2 = new Employee();
        emp2.setEmpId(13);
        emp2.setEmpName("Shyam");

        Project p1 = new Project();
        p1.setProjectId(2);
        p1.setProjectName("ChatBot");

        Project p2 = new Project();
        p2.setProjectId(3);
        p2.setProjectName("ECommerce Website");

        List<Employee> employees = new ArrayList<>();
        List<Project> projects = new ArrayList<>();

        employees.add(emp1);
        employees.add(emp2);

        projects.add(p1);
        projects.add(p2);

        emp1.setProjects(projects); //here I have assigned 2 projects to emp1
        p2.setEmployees(employees); // here I have assigned 2 employees to Project p2

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(emp1);
        session.save(emp2);
        session.save(p1);
        session.save(p2);

        tx.commit();
        session.close();


        sessionFactory.close();
    }
}
