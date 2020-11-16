package de.ovsiannikov.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* de.ovsiannikov.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {
    }

    // create pointcut for getter methods
    @Pointcut("execution(* de.ovsiannikov.aopdemo.dao.*.get*(..))")
    private void getter() {
    }

    // create pointcut for setter methods
    @Pointcut("execution(* de.ovsiannikov.aopdemo.dao.*.set*(..))")
    private void setter() {
    }

    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {

        System.out.println("\n======>>> Executing @Before advice on all methods in a package excluding getters and setters");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {

        System.out.println("\n======>>> Performing API analytics excluding getters and setters");
    }
}
