package br.com.java_springboot_testsunit_testsintergracao.dtos;

import br.com.java_springboot_testsunit_testsintergracao.entities.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UserDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotBlank(message = "Campo obrigatório.")
    private String firstName;
    private String lastName;
    @Email(message = "Entre com um e-mail válido.")
    private String email;

    Set<RoleDto> roles = new HashSet<>();

    public UserDto() {
    }

    public UserDto(Integer id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public UserDto(User userEntity) {
        this.id = userEntity.getId();
        this.firstName = userEntity.getFirstName();
        this.lastName = userEntity.getLastName();
        this.email = userEntity.getEmail();
        userEntity.getRoles().forEach(role -> this.roles.add(new RoleDto(role)));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDto> roles) {
        this.roles = roles;
    }
}
