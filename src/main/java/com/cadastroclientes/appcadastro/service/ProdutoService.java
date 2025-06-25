package com.cadastroclientes.appcadastro.service;

import com.cadastroclientes.appcadastro.domain.Fornecedor;
import com.cadastroclientes.appcadastro.domain.Produto;
import com.cadastroclientes.appcadastro.repository.FornecedorRepository;
import com.cadastroclientes.appcadastro.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Optional<Produto> findById(Long id) {
        return repository.findById(id);
    }

    public Produto insert(Produto obj, Long idFornecedor) {
        if (idFornecedor != null) {
            Optional<Fornecedor> fornecedor = fornecedorRepository.findById(idFornecedor);
            if (fornecedor.isPresent()) {
                obj.setFornecedor(fornecedor.get());
            } else {
                throw new IllegalArgumentException("Fornecedor com ID" + idFornecedor + "não encontrado");
            }
        } else {
            obj.setFornecedor(null);
        }
        return repository.save(obj);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Produto update(Produto obj, Long id) {
        Produto product = repository.getReferenceById(id);
        updateProduct(product, obj);
        return repository.save(product);
    }

    private void updateProduct(Produto product, Produto obj) {
        product.setNome(obj.getNome());
        product.setDescricao(obj.getDescricao());
        product.setDataCadastro(obj.getDataCadastro());
    }
}
