package com.beltrani.osworks.domain.model;

import org.springframework.format.annotation.DateTimeFormat;

public class ServiceOrder {
    
    private Long id;
    private String descricao;
    private Double preco;
    private DateTimeFormat dataAbertura;
    private DateTimeFormat dataFializacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public DateTimeFormat getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(DateTimeFormat dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public DateTimeFormat getDataFializacao() {
        return dataFializacao;
    }

    public void setDataFializacao(DateTimeFormat dataFializacao) {
        this.dataFializacao = dataFializacao;
    }

    
}