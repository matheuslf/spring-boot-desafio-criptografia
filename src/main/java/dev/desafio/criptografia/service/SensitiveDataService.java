package dev.desafio.criptografia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.desafio.criptografia.model.SensitiveData;
import dev.desafio.criptografia.repository.SensitiveDataRepository;

@Service
public class SensitiveDataService {

    @Autowired
    private SensitiveDataRepository repository;

    public List<SensitiveData> findAll() {
        return repository.findAll();
    }

    public SensitiveData save(SensitiveData data) {
        return repository.save(data);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
}
