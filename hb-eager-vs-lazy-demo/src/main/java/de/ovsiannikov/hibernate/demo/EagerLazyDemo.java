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

            // commit transaction
            session.getTransaction().commit();

            // since course are lazy loaded ... this should fail
            // close the session
            session.close();

            // get courses for the instructor
            System.out.println("luv2code : Courses: " + tempInstructor.getCourses());

            System.out.println("Done!");

        } finally {
            // add clean up code
            session.close();
            factory.close();
        }
    }
}
