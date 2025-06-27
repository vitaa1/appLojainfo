package com.cadastroclientes.appcadastro.service;

import com.cadastroclientes.appcadastro.domain.Fornecedor;
import com.cadastroclientes.appcadastro.repository.FornecedorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    FornecedorRepository repository;

    public List<Fornecedor> findAll() {
        return repository.findAll();
    }

    public Optional<Fornecedor> findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O id nao pode ser nulo");
        }
        return Optional.ofNullable(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Fornecedor nao encontrado")));
    }

    public Fornecedor insert(Fornecedor obj) {
        return repository.save(obj);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Fornecedor update(Fornecedor obj, Long id) {
        Fornecedor fornecedor = repository.getReferenceById(id);
        updateFornecedor(obj, id);
        return repository.save(fornecedor);
    }

    private void updateFornecedor(Fornecedor obj, Long id) {
        obj.setNomeFantasia(obj.getNomeFantasia());
        obj.setRazaoSocial(obj.getRazaoSocial());
        obj.setCnpj(obj.getCnpj());
    }
}
