package de.ovsiannikov.springdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    // setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations
    @Pointcut("execution(* de.ovsiannikov.springdemo.controller.*.*(..))")
    private void forControllerPackage() {
    }

    // do the same for service and dao
    @Pointcut("execution(* de.ovsiannikov.springdemo.service.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("execution(* de.ovsiannikov.springdemo.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {
    }

    // add @Before advice

    // add @AfterReturning advice
}
