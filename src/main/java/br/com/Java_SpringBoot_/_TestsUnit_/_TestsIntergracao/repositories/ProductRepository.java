package br.com.Java_SpringBoot_._TestsUnit_._TestsIntergracao.repositories;

import br.com.Java_SpringBoot_._TestsUnit_._TestsIntergracao.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
