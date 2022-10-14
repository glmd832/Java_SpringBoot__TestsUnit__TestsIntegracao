package br.com.java_springboot_testsunit_testsintergracao.services;

import br.com.java_springboot_testsunit_testsintergracao.dtos.ProductDto;
import br.com.java_springboot_testsunit_testsintergracao.entities.Product;
import br.com.java_springboot_testsunit_testsintergracao.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> findAll() {
        List<Product> list = productRepository.findAll();
        return list.stream().map(product ->
            new ProductDto(product, product.getCategories())).collect(Collectors.toList());
    }
}
