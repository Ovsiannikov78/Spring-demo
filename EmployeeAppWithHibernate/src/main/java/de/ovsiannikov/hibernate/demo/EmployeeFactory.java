package de.ovsiannikov.hibernate.demo;


import de.ovsiannikov.hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;


public class EmployeeFactory {
    public static void main(String[] args) {
        SessionFactory factory = (new Configuration()).configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session = factory.openSession();

        try {
            System.out.println("Creating new Employee objects");
            Employee employee1 = new Employee("Greg","Washington","Google");
            Employee employee2 = new Employee("Alex","Schmidt","Siemens");
            Employee employee3 = new Employee("Inga","Schwarz","Idealo");
            Employee employee4 = new Employee("Yan","Maslov","Google");
            Employee employee5 = new Employee("Ivan","Petrov","Netflix");

            List<Employee> employeeList = Arrays.asList(employee1,employee2,employee3,employee4,employee5);

            session.beginTransaction();

            System.out.println("\nSaving the Employees...");
            for (Employee employee : employeeList) {
                session.save(employee);
            }
            session.getTransaction().commit();
            System.out.println("\nAll employees are successfully saved !!!");

        }finally {
            factory.close();
        }
    }
}
