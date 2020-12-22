package de.ovsiannikov.springboot.cruddemo.dao;

import de.ovsiannikov.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
