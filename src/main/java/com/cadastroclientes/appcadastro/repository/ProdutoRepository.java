package com.cadastroclientes.appcadastro.repository;

import com.cadastroclientes.appcadastro.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
