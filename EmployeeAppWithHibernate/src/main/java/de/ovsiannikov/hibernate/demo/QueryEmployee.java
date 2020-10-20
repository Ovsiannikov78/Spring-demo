package de.ovsiannikov.hibernate.demo;


import de.ovsiannikov.hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;


public class QueryEmployee {
    public static void main(String[] args) {
        SessionFactory factory = (new Configuration()).configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            List employees = session.createQuery("from Employee").getResultList();
            displayEmployees(employees);

            employees = session.createQuery("from Employee e where e.company='Google'").getResultList();
            System.out.println("\nEmployees working for Google");
            displayEmployees(employees);

            session.getTransaction().commit();
            System.out.println("\nDone !!!");

        } finally {
            factory.close();
        }
    }

    private static void displayEmployees(List<Employee> theStudents) {
        Iterator it = theStudents.iterator();

        while (it.hasNext()) {
            Employee tempStudent = (Employee) it.next();
            System.out.println(tempStudent);
        }
    }
}
