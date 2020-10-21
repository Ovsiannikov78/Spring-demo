package de.ovsiannikov.hibernate.demo;
import de.ovsiannikov.hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


public class EmployeeFactory {
    public static void main(String[] args) {
        SessionFactory factory = (new Configuration()).configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new Employee objects");

            String em1DateOfBirthStr = "20/04/1982";
            String em2DateOfBirthStr = "04/08/1971";
            String em3DateOfBirthStr = "30/01/1990";
            String em4DateOfBirthStr = "11/02/1983";
            String em5DateOfBirthStr = "17/07/1975";

            LocalDate em1DateOfBirth = DateUtils.parseDate(em1DateOfBirthStr);
            LocalDate em2DateOfBirth = DateUtils.parseDate(em2DateOfBirthStr);
            LocalDate em3DateOfBirth = DateUtils.parseDate(em3DateOfBirthStr);
            LocalDate em4DateOfBirth = DateUtils.parseDate(em4DateOfBirthStr);
            LocalDate em5DateOfBirth = DateUtils.parseDate(em5DateOfBirthStr);


            Employee employee1 = new Employee("Greg", "Washington", em1DateOfBirth, "Google");
            Employee employee2 = new Employee("Alex", "Schmidt", em2DateOfBirth, "Siemens");
            Employee employee3 = new Employee("Inga", "Schwarz", em3DateOfBirth, "Idealo");
            Employee employee4 = new Employee("Yan", "Maslov", em4DateOfBirth, "Google");
            Employee employee5 = new Employee("Ivan", "Petrov", em5DateOfBirth, "Netflix");

            List<Employee> employeeList = Arrays.asList(employee1, employee2, employee3, employee4, employee5);

            session.beginTransaction();

            System.out.println("\nSaving the Employees...");
            for (Employee employee : employeeList) {
                session.save(employee);
            }
            session.getTransaction().commit();
            System.out.println("\nAll employees are successfully saved !!!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
