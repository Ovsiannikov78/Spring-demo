package de.ovsiannikov.hibernate.demo;

import de.ovsiannikov.hibernate.demo.entity.Course;
import de.ovsiannikov.hibernate.demo.entity.Instructor;
import de.ovsiannikov.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class EagerLazyDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // get the instructor from db
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            System.out.println("luv2code : Instructor: " + tempInstructor);

            // Option 1: call getter method while session is open.
            // The courses are loaded  to the memory !!! But we can get them only on demand as lazy data !!!
            System.out.println("luv2code : Courses: " + tempInstructor.getCourses());

            // commit transaction
            session.getTransaction().commit();

            // close the session
            session.close();

            System.out.printf("\nluv2code : The session is now closed!\n");
            // get courses for the instructor from the memory !!!
            System.out.println("\nluv2code : Courses: " + tempInstructor.getCourses());

            System.out.println("Done!");

        } finally {
            // add clean up code
            session.close();
            factory.close();
        }
    }
}
