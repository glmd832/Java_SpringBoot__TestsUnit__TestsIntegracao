package br.com.java_springboot_testsunit_testsintergracao.services;

import br.com.java_springboot_testsunit_testsintergracao.dtos.CategoryDto;
import br.com.java_springboot_testsunit_testsintergracao.dtos.ProductDto;
import br.com.java_springboot_testsunit_testsintergracao.entities.Category;
import br.com.java_springboot_testsunit_testsintergracao.entities.Product;
import br.com.java_springboot_testsunit_testsintergracao.repositories.CategoryRepository;
import br.com.java_springboot_testsunit_testsintergracao.repositories.ProductRepository;
import br.com.java_springboot_testsunit_testsintergracao.services.exceptions.DatabaseException;
import br.com.java_springboot_testsunit_testsintergracao.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Transactional
    public ProductDto insert(ProductDto productDto) {
        Product entity = new Product();
        copyDtoToEntity(productDto, entity);
        entity = productRepository.save(entity);
        return new ProductDto(entity);
    }

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

    @Transactional
    public ProductDto update(Integer id, ProductDto productDto) {
        try {
            Product entity = productRepository.getReferenceById(id);
            copyDtoToEntity(productDto, entity);
            entity = productRepository.save(entity);
            return new ProductDto(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id não encontrado: " + id);
        }
    }

    public void delete(Integer id) {
        try {
            productRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id não encontrado: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação de integridade");
        }
    }

    private void copyDtoToEntity(ProductDto dto, Product entity) {
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImage(dto.getImage());

        entity.getCategories().clear(); // 1 2
        for (CategoryDto catDto : dto.getCategories()) {
            Category category = categoryRepository.getReferenceById(catDto.getId());
            entity.getCategories().add(category);
        }
    }
}
