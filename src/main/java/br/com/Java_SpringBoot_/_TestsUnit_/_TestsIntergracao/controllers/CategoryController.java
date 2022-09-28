package br.com.Java_SpringBoot_._TestsUnit_._TestsIntergracao.controllers;

import br.com.Java_SpringBoot_._TestsUnit_._TestsIntergracao.dtos.CategoryDto;
import br.com.Java_SpringBoot_._TestsUnit_._TestsIntergracao.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll(){
        List<CategoryDto> list = categoryService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
