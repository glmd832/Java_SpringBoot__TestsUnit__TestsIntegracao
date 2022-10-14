package br.com.java_springboot_testsunit_testsintergracao.dtos;

import br.com.java_springboot_testsunit_testsintergracao.entities.Category;

import java.io.Serial;
import java.io.Serializable;

public class CategoryDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;

    public CategoryDto() {
    }

    public CategoryDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryDto(Category categoryEntity) {
        this.id = categoryEntity.getId();
        this.name = categoryEntity.getName();
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
