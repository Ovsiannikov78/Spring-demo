package de.ovsiannikov.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class KickboxingCoach implements Coach {

    private FortuneService fortuneService;

    @Value("${email1}")
    private String email1;

    @Value("${teamName}")
    private String teamName;

    public KickboxingCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout() {
        return "Practice low kick 20 times";
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public String getEmail1() {
        return email1;
    }

    public String getTeamName() {
        return teamName;
    }
}
