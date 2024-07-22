package dev.desafio.criptografia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.desafio.criptografia.model.SensitiveData;
import dev.desafio.criptografia.service.SensitiveDataService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/sensitive-data")
public class SensitiveDataController {

    @Autowired
    private SensitiveDataService service;

    @GetMapping
    public List<SensitiveData> getAll() {
        return service.findAll();
    }

    @PostMapping
    public SensitiveData create(@RequestBody SensitiveData data) {
        return service.save(data);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
