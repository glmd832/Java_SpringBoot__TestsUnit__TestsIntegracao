package br.com.java_springboot_testsunit_testsintergracao.repositories;

import br.com.java_springboot_testsunit_testsintergracao.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
