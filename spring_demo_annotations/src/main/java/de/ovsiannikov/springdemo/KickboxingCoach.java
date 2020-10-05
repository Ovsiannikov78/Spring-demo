package de.ovsiannikov.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class KickboxingCoach implements Coach {

    @Autowired
    @Qualifier("fileFortuneService")
    private FortuneService fortuneService;

    public String getDailyWorkout() {
        return "Practice low kick 20 times";
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
