package br.com.java_springboot_testsunit_testsintergracao.repositories;

import br.com.java_springboot_testsunit_testsintergracao.entities.Departament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentRepository extends JpaRepository<Departament, Integer> {
}
