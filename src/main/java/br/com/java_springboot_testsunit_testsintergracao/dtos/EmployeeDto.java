package br.com.java_springboot_testsunit_testsintergracao.dtos;

import br.com.java_springboot_testsunit_testsintergracao.entities.Employee;

import java.io.Serializable;

public class EmployeeDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String email;
    private Integer department_id;

    public EmployeeDto() {
    }

    public EmployeeDto(Integer id, String name, String email, Integer department_id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department_id = department_id;
    }

    public EmployeeDto(Employee employeeEntity) {
        this.id = employeeEntity.getId();
        this.name = employeeEntity.getName();
        this.email = employeeEntity.getEmail();
        this.department_id = employeeEntity.getDepartament().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }
}
