package br.com.Java_SpringBoot_._TestsUnit_._TestsIntergracao.repositories;

import br.com.Java_SpringBoot_._TestsUnit_._TestsIntergracao.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
