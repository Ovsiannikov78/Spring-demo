package de.ovsiannikov.hibernate.demo;

import de.ovsiannikov.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndReviewsDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // create a course
            Course tempCourse = new Course("Spring & Hibernate - full course for beginners");


            // save the course
            System.out.println("\nSaving the course...");
            session.save(tempCourse);
            System.out.println("Saved the course: " + tempCourse);

            // create the student
            Student theStudent1 = new Student("Alex", "Bulkin", "alex@gmail.com");
            Student theStudent2 = new Student("Jack", "Gibson", "g.gibson@gmail.com");

            // add students to the course
            tempCourse.addStudent(theStudent1);
            tempCourse.addStudent(theStudent2);

            // save the students
            System.out.println("\nSaving the students...");
            session.save(theStudent1);
            session.save(theStudent2);
            System.out.println("Saved the students: " + tempCourse.getStudents());

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            // add clean up code
            session.close();
            factory.close();
        }
    }
}

