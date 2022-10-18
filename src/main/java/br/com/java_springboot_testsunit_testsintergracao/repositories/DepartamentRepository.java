package br.com.java_springboot_testsunit_testsintergracao.repositories;

import br.com.java_springboot_testsunit_testsintergracao.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentRepository extends JpaRepository<Department, Integer> {
}
