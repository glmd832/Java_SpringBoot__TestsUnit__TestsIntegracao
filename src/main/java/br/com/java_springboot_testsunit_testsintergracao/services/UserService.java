package br.com.java_springboot_testsunit_testsintergracao.services;

import br.com.java_springboot_testsunit_testsintergracao.dtos.UserDto;
import br.com.java_springboot_testsunit_testsintergracao.entities.User;
import br.com.java_springboot_testsunit_testsintergracao.repositories.UserRepository;
import br.com.java_springboot_testsunit_testsintergracao.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
}
