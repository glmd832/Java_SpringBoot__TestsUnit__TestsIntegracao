package br.com.Java_SpringBoot_._TestsUnit_._TestsIntergracao.repositories;

import br.com.Java_SpringBoot_._TestsUnit_._TestsIntergracao.entities.Departament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentRepository extends JpaRepository<Departament, Integer> {
}
