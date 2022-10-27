package br.com.java_springboot_testsunit_testsintergracao.controllers;

import br.com.java_springboot_testsunit_testsintergracao.dtos.CategoryDto;
import br.com.java_springboot_testsunit_testsintergracao.dtos.RoleDto;
import br.com.java_springboot_testsunit_testsintergracao.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping
    public ResponseEntity<RoleDto> insert(@RequestBody RoleDto roleDto) {
        roleService.insert(roleDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(roleDto.getId()).toUri();
        return ResponseEntity.created(uri).body(roleDto);
    }

    @GetMapping
    public ResponseEntity<List<RoleDto>> findAll() {
        List<RoleDto> list = roleService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RoleDto> findById(@PathVariable Integer id) {
        RoleDto roleDto = roleService.findById(id);
        return ResponseEntity.ok().body(roleDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        roleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
