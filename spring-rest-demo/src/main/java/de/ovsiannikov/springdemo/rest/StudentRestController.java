package de.ovsiannikov.springdemo.rest;

import de.ovsiannikov.springdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstructor to load the student data ... only once!

    @PostConstruct
    public void loadData() {

        theStudents = Arrays.asList(new Student("Vlad", "Schneider"),
                new Student("Jack", "Bond"),
                new Student("Alina", "Gibson"));
    }

    // define endpoint for "/student" - return list of students

    @GetMapping("/students")
    public List<Student> getStudent() {

        return theStudents;
    }

    // define endpoint for "/students/{studentId}" - return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        // just index into the list ... keep it simple for now

        return theStudents.get(studentId);

    }
}
