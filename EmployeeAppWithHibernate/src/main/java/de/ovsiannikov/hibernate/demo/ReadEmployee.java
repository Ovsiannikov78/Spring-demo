package de.ovsiannikov.hibernate.demo;


import de.ovsiannikov.hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;


public class ReadEmployee {
    public static void main(String[] args) {
        SessionFactory factory = (new Configuration()).configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session = factory.openSession();

        try {
            System.out.println("Creating new Employee objects");
            Employee newEmployee = new Employee("Viktor", "Kirilov", "Amazon");

            session.beginTransaction();

            System.out.println("Save the employee...");
            session.save(newEmployee);
            System.out.println(newEmployee);

            session.getTransaction().commit();
            System.out.println("Saved employee. Generated id: " + newEmployee.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting employee with id: " + newEmployee.getId());
            Employee myEmployee = session.get(Employee.class, newEmployee.getId());
            System.out.println("Get complete: " + myEmployee);

            session.getTransaction().commit();
            System.out.println("\nDone !!!");

        } finally {
            factory.close();
        }
    }
}
