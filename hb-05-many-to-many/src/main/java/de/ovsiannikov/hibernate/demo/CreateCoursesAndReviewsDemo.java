package de.ovsiannikov.hibernate.demo;

import de.ovsiannikov.hibernate.demo.entity.Course;
import de.ovsiannikov.hibernate.demo.entity.Instructor;
import de.ovsiannikov.hibernate.demo.entity.InstructorDetail;
import de.ovsiannikov.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCoursesAndReviewsDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // create a course
            Course tempCourse = new Course("Spring & Hibernate - full course for beginners");

            // add some reviews
            tempCourse.addReview(new Review("Great course ... love it"));
            tempCourse.addReview(new Review("Very useful. Thank you !!!"));
            tempCourse.addReview(new Review("Good job! Well done!"));

            // save the course ... and leverage the cascade all
            System.out.println("Saving the course");
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());
            session.save(tempCourse);

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

