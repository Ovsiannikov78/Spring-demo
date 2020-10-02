package de.ovsiannikov.springdemo;

public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    public BaseballCoach() {
    }

    public BaseballCoach(FortuneService theFortuneService) {
        this.fortuneService = theFortuneService;
    }

    public String getDailyWorkout() {
        return "Spend 30 min on batting practice";
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}

