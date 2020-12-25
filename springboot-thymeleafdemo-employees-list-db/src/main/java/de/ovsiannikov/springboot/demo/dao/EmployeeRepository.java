package de.ovsiannikov.springboot.demo.dao;

import de.ovsiannikov.springboot.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
