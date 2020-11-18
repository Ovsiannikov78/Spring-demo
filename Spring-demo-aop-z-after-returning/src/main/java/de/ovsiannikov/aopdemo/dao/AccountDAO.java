package de.ovsiannikov.aopdemo.dao;

import de.ovsiannikov.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    // add a new method: findAccount()
    public List<Account> findAccount() {

        // create sample accounts
        Account temp1 = new Account("Jack", "Silver");
        Account temp2 = new Account("Alex", "Platinum");
        Account temp3 = new Account("Inga", "Gold");

        List<Account> myAccounts = Arrays.asList(temp1, temp2, temp3);

        return myAccounts;
    }

    public void addAccount(Account theAccount, boolean vipFlag) {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
