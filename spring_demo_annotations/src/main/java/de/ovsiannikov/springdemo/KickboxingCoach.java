package de.ovsiannikov.springdemo;

import org.springframework.stereotype.Component;

@Component
public class KickboxingCoach implements Coach {

    public String getDailyWorkout() {
        return "Practice low kick 20 times";
    }
}
