package br.com.java_springboot_testsunit_testsintergracao.services;

import br.com.java_springboot_testsunit_testsintergracao.dtos.ProductDto;
import br.com.java_springboot_testsunit_testsintergracao.entities.Product;
import br.com.java_springboot_testsunit_testsintergracao.repositories.ProductRepository;
import br.com.java_springboot_testsunit_testsintergracao.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDto> findAll() {
        List<Product> list = productRepository.findAll();
        return list.stream().map(product ->
            new ProductDto(product, product.getCategories())).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProductDto findById(Integer id) {
        Optional<Product> object = productRepository.findById(id);
        Product product = object.orElseThrow(() ->
                new ResourceNotFoundException("Id não encontado: " + id));
        return new ProductDto(product, product.getCategories());
    }
}
