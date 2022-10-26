package br.com.java_springboot_testsunit_testsintergracao.services;

import br.com.java_springboot_testsunit_testsintergracao.dtos.RoleDto;
import br.com.java_springboot_testsunit_testsintergracao.entities.Role;
import br.com.java_springboot_testsunit_testsintergracao.repositories.RoleRepository;
import br.com.java_springboot_testsunit_testsintergracao.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

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
}
