package br.com.java_springboot_testsunit_testsintergracao.repositories;

import br.com.java_springboot_testsunit_testsintergracao.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
