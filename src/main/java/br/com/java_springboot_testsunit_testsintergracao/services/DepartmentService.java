package br.com.java_springboot_testsunit_testsintergracao.services;

import br.com.java_springboot_testsunit_testsintergracao.dtos.DepartmentDto;
import br.com.java_springboot_testsunit_testsintergracao.entities.Department;
import br.com.java_springboot_testsunit_testsintergracao.repositories.DepartamentRepository;
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
public class DepartmentService {

    @Autowired
    DepartamentRepository departamentRepository;

    @Transactional
    public DepartmentDto insert(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setName(departmentDto.getName());
        department = departamentRepository.save(department);
        return new DepartmentDto(department);
    }

    @Transactional(readOnly = true)
    public List<DepartmentDto> findAll() {
        List<Department> list = departamentRepository.findAll();
        return list.stream().map(DepartmentDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DepartmentDto findById(Integer id) {
        Optional<Department> object = departamentRepository.findById(id);
        Department department = object.orElseThrow(() ->
                new ResourceNotFoundException("Id não existe"));
        return new DepartmentDto(department);
    }

    @Transactional
    public DepartmentDto update(Integer id, DepartmentDto departmentDto) {
        try {
            Department department = departamentRepository.getReferenceById(id);
            department.setName(departmentDto.getName());
            department = departamentRepository.save(department);
            return new DepartmentDto(department);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id não encontrado: " + id);
        }
    }

    public void delete(Integer id) {
        try {
            departamentRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id não encontrado: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação de integridade no banco de dados");
        }
    }
}
