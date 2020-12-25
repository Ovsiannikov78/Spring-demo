package de.ovsiannikov.springboot.demo.controller;

import de.ovsiannikov.springboot.demo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    // load employee data
    private List<Employee> theEmployees;

    @PostConstruct
    private void loadData() {

        // create employees
        Employee emp1 = new Employee(1, "John", "Schatz", "schatz@mail.de");
        Employee emp2 = new Employee(2, "Alex", "Gastro", "gastro@gmail.de");
        Employee emp3 = new Employee(3, "Liza", "Nickson", "l.nickson@aol.com");

        // create the list and add employees to the list
        theEmployees = Arrays.asList(emp1, emp2, emp3);

    }

    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
    }
}
