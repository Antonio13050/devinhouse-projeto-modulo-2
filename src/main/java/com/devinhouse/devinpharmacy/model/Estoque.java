package com.devinhouse.devinpharmacy.model;

import com.devinhouse.devinpharmacy.model.dto.EstoqueRequestDTO;
import com.devinhouse.devinpharmacy.model.dto.FarmaciaRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "ESTOQUES")
@IdClass(IdEstoque.class)
public class Estoque {
    @Id
    private Long cnpj;
    @Id
    private Integer nroRegistro;
    private Integer quantidade;
    private LocalDateTime dataAtualizacao;

    public Estoque() {
    }

    public Estoque(EstoqueRequestDTO body) {
        this.cnpj = body.cnpj();
        this.nroRegistro = body.nroRegistro();
        this.quantidade = body.quantidade();
        this.dataAtualizacao = LocalDateTime.now();
    }

    public Long getCnpj() {
        return cnpj;
    }

    public Integer getNroRegistro() {
        return nroRegistro;
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