package dev.desafio.criptografia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.desafio.criptografia.model.SensitiveData;

public interface SensitiveDataRepository extends JpaRepository<SensitiveData, Long> {
    
}
