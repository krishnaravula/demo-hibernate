package com.rsk.api;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Students.class)
                .buildSessionFactory();


        Session session = sessionFactory.openSession();


        Students student = new Students();

        session.beginTransaction();

        student.setName("rsk2");
        student.setCountry("India2");
        Students students = session.get(Students.class, 12);

        session.persist(student);
        session.getTransaction().commit();


        System.out.println(students);
        sessionFactory.close();
        session.close();
    }
}
