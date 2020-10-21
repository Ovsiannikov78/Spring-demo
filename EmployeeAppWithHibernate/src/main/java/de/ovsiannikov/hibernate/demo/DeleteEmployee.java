package de.ovsiannikov.hibernate.demo;


import de.ovsiannikov.hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteEmployee {
    public static void main(String[] args) {
        SessionFactory factory = (new Configuration()).configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session = factory.openSession();

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nDeleting employee with a duplicate id column");
            session.createQuery("delete from Employee e where e.id > 5 and e.id < 11 ").executeUpdate();

            session.createQuery("delete from Employee e where e.id > 11 ").executeUpdate();

            session.getTransaction().commit();
            System.out.println("\nDone !!!");

        } finally {
            factory.close();
        }
    }
}
