package de.ovsiannikov.hibernate.demo;

import de.ovsiannikov.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // delete the student id=2
            System.out.println("\nDeleting student id=2");
            session.createQuery("delete  from  Student where  id=2").executeUpdate();

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("\nDone!");

        } finally {
            factory.close();
        }
    }
}
