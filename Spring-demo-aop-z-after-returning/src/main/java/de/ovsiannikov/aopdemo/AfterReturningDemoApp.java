package de.ovsiannikov.aopdemo;

import de.ovsiannikov.aopdemo.dao.AccountDAO;
import de.ovsiannikov.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the accounts
        List<Account> theAccounts = theAccountDAO.findAccount();

        // display the accounts
        System.out.println("\n\nMain program: AfterReturningDemoApp");
        System.out.println("----------------------------------------");

        System.out.println(theAccounts);

        System.out.println("\n");

        // close the context
        context.close();
    }
}
