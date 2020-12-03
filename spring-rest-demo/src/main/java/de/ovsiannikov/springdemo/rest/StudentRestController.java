package de.ovsiannikov.springdemo.rest;

import de.ovsiannikov.springdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // define endpoint for "/student" - return list of students

    @GetMapping("/students")
    public List<Student> getStudent() {

        List<Student> theStudents = Arrays.asList(new Student("Vlad", "Schneider"),
                new Student("Jack", "Bond"),
                new Student("Alina", "Gibson"));

        return theStudents;
    }
}
