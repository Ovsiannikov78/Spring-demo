package de.ovsiannikov.springboot.demo.springbootdemoproject.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class TestRestController {

    // expose "/" that return "Hello World"

    @GetMapping("/")
    public String syaHello() {
        return "Hello World! New Year is very soon! Time on server is " + LocalDateTime.now();
    }

    // expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }

    // expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day.";
    }
}
