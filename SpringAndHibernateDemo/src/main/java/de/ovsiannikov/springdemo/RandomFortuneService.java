package de.ovsiannikov.springdemo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomFortuneService implements FortuneService {
    private List<String> list = Arrays.asList("Today is your lucky day!",
            "Today is your day! Let's do a crazy workout !",
            "You are a Super hero! You can do it!");
    private Random random = new Random();

    public String getFortune() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
