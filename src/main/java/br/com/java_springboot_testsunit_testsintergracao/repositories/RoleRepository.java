package br.com.java_springboot_testsunit_testsintergracao.repositories;

import br.com.java_springboot_testsunit_testsintergracao.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
