package br.com.java_springboot_testsunit_testsintergracao.services;

import br.com.java_springboot_testsunit_testsintergracao.dtos.CategoryDto;
import br.com.java_springboot_testsunit_testsintergracao.entities.Category;
import br.com.java_springboot_testsunit_testsintergracao.repositories.CategoryRepository;
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
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public void insert(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category = categoryRepository.save(category);
        new CategoryDto(category);
    }

    @Transactional(readOnly = true)
    public List<CategoryDto> findAll() {
        List<Category> list = categoryRepository.findAll();
        return list.stream().map(CategoryDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CategoryDto findById(Integer id) {
        Optional<Category> object = categoryRepository.findById(id);//optional caso venha nula não da exceção
        Category categoryEntity = object.orElseThrow(() ->
                new ResourceNotFoundException("Id inexistente"));
        return new CategoryDto(categoryEntity);
    }

    public CategoryDto update(Integer id, CategoryDto categoryDto) {
        try {
            Category category = categoryRepository.getReferenceById(id);
            category.setName(categoryDto.getName());
            category = categoryRepository.save(category);
            return new CategoryDto(category);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id " + id + " não encontrado");
        }
    }

    public void delete(Integer id) {
        try {
            categoryRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id não encontrado: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação de integridade");
        }
    }
}
