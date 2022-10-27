package br.com.java_springboot_testsunit_testsintergracao.services;

import br.com.java_springboot_testsunit_testsintergracao.dtos.RoleDto;
import br.com.java_springboot_testsunit_testsintergracao.dtos.UserDto;
import br.com.java_springboot_testsunit_testsintergracao.entities.Role;
import br.com.java_springboot_testsunit_testsintergracao.entities.User;
import br.com.java_springboot_testsunit_testsintergracao.repositories.UserRepository;
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
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserDto> findAll() {
        List<User> list = userRepository.findAll();
        return list.stream().map(UserDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UserDto findById(Integer id) {
        Optional<User> object = userRepository.findById(id);
        User user = object.orElseThrow(() ->
                new ResourceNotFoundException("Este ID não existe em nosso sistema."));
        return new UserDto(user);
    }

    public void delete(Integer id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id não encontrado: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação de integridade");
        }
    }
}
