package de.ovsiannikov.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println("======= TennisCoach: inside default constructor ======");
    }

    // define a setter method
    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("======= TennisCoach: inside setFortuneService() method ======");
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
