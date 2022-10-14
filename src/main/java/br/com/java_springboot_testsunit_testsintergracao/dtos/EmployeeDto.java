package br.com.java_springboot_testsunit_testsintergracao.dtos;

import br.com.java_springboot_testsunit_testsintergracao.entities.Employee;

import java.io.Serial;
import java.io.Serializable;

public class EmployeeDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String email;
    private Integer departmentId;

    public EmployeeDto() {
    }

    public EmployeeDto(Integer id, String name, String email, Integer departmentId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.departmentId = departmentId;
    }

    public EmployeeDto(Employee employeeEntity) {
        this.id = employeeEntity.getId();
        this.name = employeeEntity.getName();
        this.email = employeeEntity.getEmail();
        this.departmentId = employeeEntity.getDepartament().getId();
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

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
