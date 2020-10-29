package de.ovsiannikov.springdemo;

public class MotivationalFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Excellent !!! Keep going also and you will be the champion !";
    }
}
