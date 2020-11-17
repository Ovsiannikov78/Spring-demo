package de.ovsiannikov.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyApiAnalyticsAspect {
    @Before("de.ovsiannikov.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {

        System.out.println("\n======>>> Performing API analytics excluding getters and setters");
    }
}
