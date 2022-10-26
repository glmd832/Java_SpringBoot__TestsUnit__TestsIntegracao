package br.com.java_springboot_testsunit_testsintergracao.controllers;

import br.com.java_springboot_testsunit_testsintergracao.dtos.DepartmentDto;
import br.com.java_springboot_testsunit_testsintergracao.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> insert(@RequestBody DepartmentDto departmentDto) {
        departmentDto = departmentService.insert(departmentDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(departmentDto.getId()).toUri();
        return ResponseEntity.created(uri).body(departmentDto);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> findAll(){
        List<DepartmentDto> list = departmentService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartmentDto> findById(@PathVariable Integer id) {
        DepartmentDto departmentDto = departmentService.findById(id);
        return ResponseEntity.ok().body(departmentDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DepartmentDto> update(@PathVariable Integer id, @RequestBody DepartmentDto departmentDto) {
        departmentDto = departmentService.update(id, departmentDto);
        return ResponseEntity.ok().body(departmentDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        departmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
