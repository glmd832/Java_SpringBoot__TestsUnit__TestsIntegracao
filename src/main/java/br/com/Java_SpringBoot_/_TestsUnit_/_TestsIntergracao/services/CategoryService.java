package br.com.Java_SpringBoot_._TestsUnit_._TestsIntergracao.services;

import br.com.Java_SpringBoot_._TestsUnit_._TestsIntergracao.dtos.CategoryDto;
import br.com.Java_SpringBoot_._TestsUnit_._TestsIntergracao.entities.Category;
import br.com.Java_SpringBoot_._TestsUnit_._TestsIntergracao.repositories.CategoryRepository;
import br.com.Java_SpringBoot_._TestsUnit_._TestsIntergracao.services.exceptions.DatabaseException;
import br.com.Java_SpringBoot_._TestsUnit_._TestsIntergracao.services.exceptions.ResourceNotFoundException;
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

    @Transactional(readOnly = true)
    public List<CategoryDto> findAll(){
        List<Category> list = categoryRepository.findAll();
        return list.stream().map(category -> new CategoryDto(category)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CategoryDto findById(Integer id){
        Optional<Category> object = categoryRepository.findById(id);
        Category categoryEntity = object.orElseThrow(() ->
                new ResourceNotFoundException("Id inexistente"));
        return new CategoryDto(categoryEntity);
    }

    public void delete(Integer id){
        try {
            categoryRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id não encontrado: " + id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException("Violação de integridade");
        }
    }

    @Transactional
    public CategoryDto insert(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        category = categoryRepository.save(category);
        return new CategoryDto(category);
    }

    public CategoryDto update(Integer id, CategoryDto categoryDto){
        try {
            Category category = categoryRepository.getReferenceById(id);
            category.setName(categoryDto.getName());
            category = categoryRepository.save(category);
            return new CategoryDto(category);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id " + id + " não encontrado");
        }
    }
}
