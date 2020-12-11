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
}
