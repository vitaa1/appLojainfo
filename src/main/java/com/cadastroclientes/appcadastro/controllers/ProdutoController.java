package com.cadastroclientes.appcadastro.controllers;

import com.cadastroclientes.appcadastro.DTO.ProdutoDto;
import com.cadastroclientes.appcadastro.domain.Produto;
import com.cadastroclientes.appcadastro.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Produto>> findById(@PathVariable Long id) {
        Optional<Produto> obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Produto> insert (@RequestBody ProdutoDto dto) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataCadastro = LocalDate.parse(dto.getDataCadastro(), dateFormatter);
        Produto obj = new Produto();
        obj.setNome(dto.getNome());
        obj.setDescricao(dto.getDescricao());
        obj.setDataCadastro(dataCadastro);
        Produto novoProduto = service.insert(obj, dto.getIdFornecedor());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdProduto()).toUri();
        return ResponseEntity.created(uri).body(novoProduto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
