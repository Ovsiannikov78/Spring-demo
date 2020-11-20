package de.ovsiannikov.aopdemo.aspect;

import de.ovsiannikov.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* de.ovsiannikov.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        // print out which method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=========>>> Executing @Around on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now, let's execute the method
        Object result = theProceedingJoinPoint.proceed();

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        System.out.println("\n=========> Duration: " + duration / 1000.0 + " seconds");

        return result;
    }


    @After("execution(* de.ovsiannikov.aopdemo.dao.AccountDAO.findAccount(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=========>>> Executing @After (finally) on method: " + method);

    }

    @AfterThrowing(pointcut = "execution(* de.ovsiannikov.aopdemo.dao.AccountDAO.findAccount(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc) {

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=========>>> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("\n=========>>> The exception is: " + theExc);

    }

    @AfterReturning(pointcut = "execution(* de.ovsiannikov.aopdemo.dao.AccountDAO.findAccount(..))",
            returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=========>>> Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        System.out.println("\n=========>>> result is: " + result);

        // let's post-process the data ... let's modify it

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n=========>>> result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        // loop through account
        for (Account tempAccount : result) {

            // get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();

            // update the name on the account
            tempAccount.setName(theUpperName);
        }
    }

    @Before("de.ovsiannikov.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

        System.out.println("\n======>>> Executing @Before advice on all methods in a package excluding getters and setters <<<======== ");

        // display the method signature
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSig);

        // display method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop thru args
        for (Object tempArg : args) {
            System.out.println(tempArg);

            if (tempArg instanceof Account) {

                // downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;

                System.out.println("Account name: " + theAccount.getName() + "\nAccount level: " + theAccount.getLevel());
            }
        }
    }
}
