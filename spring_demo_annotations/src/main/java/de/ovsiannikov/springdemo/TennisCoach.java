package de.ovsiannikov.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("fileFortuneService")
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println("======= TennisCoach: inside default constructor ======");
    }

    // define my init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("======= TennisCoach: inside of doMyStartupStuff ======");
    }

    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("======= TennisCoach: inside of doMyCleanupStuff ======");
    }

    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
