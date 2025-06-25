package com.cadastroclientes.appcadastro.DTO;

public class ProdutoDto {
    private String nome;
    private String descricao;
    private String dataCadastro;
    private Long idFornecedor;

    public ProdutoDto() {
    }
    
    public ProdutoDto(String nome, String descricao, String dataCadastro, Long idFornecedor) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
        this.idFornecedor = idFornecedor;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getDataCadastro() {
        return dataCadastro;
    }
    public void setDatCad(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    public Long getIdFornecedor() {
        return idFornecedor;
    }
    public void setIdFornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }
}
