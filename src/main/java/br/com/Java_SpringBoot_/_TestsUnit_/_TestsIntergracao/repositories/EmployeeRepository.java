package br.com.Java_SpringBoot_._TestsUnit_._TestsIntergracao.repositories;

import br.com.Java_SpringBoot_._TestsUnit_._TestsIntergracao.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
