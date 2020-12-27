package de.ovsiannikov.springboot.demo.dao;

import de.ovsiannikov.springboot.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // add a method to sort by first name
    public List<Employee> findAllByOrderByFirstNameAsc();
}
