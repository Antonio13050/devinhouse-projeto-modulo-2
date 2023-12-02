package com.devinhouse.devinpharmacy.model.dto;

import java.time.LocalDateTime;

public class EstoqueResponseDTO{

    private Integer nroRegistro;
    private String nome;
    private Integer quantidade;
    private LocalDateTime dataAtualizacao;

    public EstoqueResponseDTO() {
    }

    public EstoqueResponseDTO(Integer nroRegistro, String nome, Integer quantidade, LocalDateTime dataAtualizacao) {
        this.nroRegistro = nroRegistro;
        this.nome = nome;
        this.quantidade = quantidade;
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNroRegistro() {
        return nroRegistro;
    }

    public void setNroRegistro(Integer nroRegistro) {
        this.nroRegistro = nroRegistro;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
