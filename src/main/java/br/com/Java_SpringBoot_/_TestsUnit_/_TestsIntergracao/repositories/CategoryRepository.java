package br.com.Java_SpringBoot_._TestsUnit_._TestsIntergracao.repositories;

import br.com.Java_SpringBoot_._TestsUnit_._TestsIntergracao.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
