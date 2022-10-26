package br.com.java_springboot_testsunit_testsintergracao.services;

import br.com.java_springboot_testsunit_testsintergracao.dtos.EmployeeDto;
import br.com.java_springboot_testsunit_testsintergracao.entities.Department;
import br.com.java_springboot_testsunit_testsintergracao.entities.Employee;
import br.com.java_springboot_testsunit_testsintergracao.repositories.EmployeeRepository;
import br.com.java_springboot_testsunit_testsintergracao.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public List<EmployeeDto> findAll() {
        List<Employee> list = employeeRepository.findAll();
        return list.stream().map(EmployeeDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EmployeeDto findById(Integer id) {
        Optional<Employee> object = employeeRepository.findById(id);
        Employee employee = object.orElseThrow(() ->
                new ResourceNotFoundException("Id não encontrado: " + id));
        return new EmployeeDto(employee);
    }
}
