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
            int studentId = 1;

            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + studentId);

            Student myStudent = session.get(Student.class, studentId);

            // delete the student id=1
            System.out.println("\nDeleting student: " + myStudent);
            session.delete(myStudent);

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("\nDone!");

        } finally {
            factory.close();
        }
    }
}
