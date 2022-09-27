package br.com.Java_SpringBoot_._TestsUnit_._TestsIntergracao.dtos;

import br.com.Java_SpringBoot_._TestsUnit_._TestsIntergracao.entities.Departament;

import java.io.Serializable;

public class DepartamentDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;

    private DepartamentDto() {
    }

    public DepartamentDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public DepartamentDto(Departament departamentEntity) {
        this.id = departamentEntity.getId();
        this.name = departamentEntity.getName();
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
