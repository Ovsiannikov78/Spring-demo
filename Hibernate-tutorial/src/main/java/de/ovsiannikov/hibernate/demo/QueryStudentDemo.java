package de.ovsiannikov.hibernate.demo;

import de.ovsiannikov.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // query students
            List theStudents = session.createQuery("from Student").getResultList();

            // display the students
            displayStudents(theStudents);

            // query students: lastName='Bond'
            theStudents = session.createQuery("from Student s where s.lastName='Bond'").getResultList();

            // display the students
            System.out.println("\n\nStudent, who have last name of Bond");
            displayStudents(theStudents);

            // query students: with lastName='Gibson' or 'firstName='Ivan'
            theStudents = session.createQuery("from Student s where s.lastName='Gibson'" +
                    "OR s.firstName='Ivan'").getResultList();

            // display the students
            System.out.println("\n\nStudent, who have last name of Gibson or first name of Ivan");
            displayStudents(theStudents);

            // query students: email='google.com'
            theStudents = session.createQuery("from Student s where s.email like '%google.com'").getResultList();

            // display the students with email ending on google.com
            System.out.println("\n\nStudent, with emails ending on google.com");
            displayStudents(theStudents);


            // commit transaction
            session.getTransaction().commit();

            System.out.println("\n\nDone!");

        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }
}
