package de.ovsiannikov.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {

        // read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // get the bean from spring container
        Coach tennisCoach = context.getBean("tennisCoach", Coach.class);
        // call a method on the bean
        System.out.println(tennisCoach.getDailyWorkout());
        // call method to get the daily fortune
        System.out.println(tennisCoach.getDailyFortune());

        /*Coach kickboxingCoach = context.getBean("kickboxingCoach", Coach.class);

        System.out.println(kickboxingCoach.getDailyWorkout());

        System.out.println(kickboxingCoach.getDailyFortune());*/


        // close the context
        context.close();
    }
}
