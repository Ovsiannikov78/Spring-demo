package de.ovsiannikov.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KickboxingCoach implements Coach {

    @Autowired
    private FortuneService fortuneService;

    /*@Autowired
    public KickboxingCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }*/

    public String getDailyWorkout() {
        return "Practice low kick 20 times";
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
