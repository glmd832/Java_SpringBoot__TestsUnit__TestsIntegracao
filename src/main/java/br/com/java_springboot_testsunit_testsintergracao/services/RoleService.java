package br.com.java_springboot_testsunit_testsintergracao.services;

import br.com.java_springboot_testsunit_testsintergracao.dtos.CategoryDto;
import br.com.java_springboot_testsunit_testsintergracao.dtos.RoleDto;
import br.com.java_springboot_testsunit_testsintergracao.entities.Category;
import br.com.java_springboot_testsunit_testsintergracao.entities.Role;
import br.com.java_springboot_testsunit_testsintergracao.repositories.RoleRepository;
import br.com.java_springboot_testsunit_testsintergracao.services.exceptions.DatabaseException;
import br.com.java_springboot_testsunit_testsintergracao.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public void insert(RoleDto roleDto) {
        Role role = new Role();
        role.setAuthority(role.getAuthority());
        role = roleRepository.save(role);
        new RoleDto(role);
    }

    @Transactional(readOnly = true)
    public List<RoleDto> findAll() {
        List<Role> list = roleRepository.findAll();
        return list.stream().map(RoleDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public RoleDto findById(Integer id) {
        Optional<Role> object = roleRepository.findById(id);
        Role role = object.orElseThrow(() ->
                new ResourceNotFoundException("Este ID não existe em nosso sistema."));
        return new RoleDto(role);
    }

    public void delete(Integer id) {
        try {
            roleRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id não encontrado: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação de integridade");
        }
    }
}
