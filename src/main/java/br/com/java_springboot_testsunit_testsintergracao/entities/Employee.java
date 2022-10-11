package br.com.java_springboot_testsunit_testsintergracao.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "table_employee")
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "departament_id")
    private Departament departament;

    public Employee() {
    }

    public Employee(Integer id, String name, String email, Departament departament) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.departament = departament;
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

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }
}
