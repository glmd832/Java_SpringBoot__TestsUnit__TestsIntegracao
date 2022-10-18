package br.com.java_springboot_testsunit_testsintergracao.dtos;

import br.com.java_springboot_testsunit_testsintergracao.entities.Department;

import java.io.Serial;
import java.io.Serializable;

public class DepartmentDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;

    private DepartmentDto() {
    }

    public DepartmentDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public DepartmentDto(Department departmentEntity) {
        this.id = departmentEntity.getId();
        this.name = departmentEntity.getName();
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
}
