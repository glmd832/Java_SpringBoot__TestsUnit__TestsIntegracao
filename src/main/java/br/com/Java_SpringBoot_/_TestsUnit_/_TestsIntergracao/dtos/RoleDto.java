package br.com.Java_SpringBoot_._TestsUnit_._TestsIntergracao.dtos;

import br.com.Java_SpringBoot_._TestsUnit_._TestsIntergracao.entities.Role;

import java.io.Serializable;

public class RoleDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String authority;

    public RoleDto() {
    }

    public RoleDto(Integer id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public RoleDto(Role roleEntity) {
        this.id = roleEntity.getId();
        this.authority = roleEntity.getAuthority();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}