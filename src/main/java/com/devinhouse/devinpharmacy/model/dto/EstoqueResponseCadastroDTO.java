package com.devinhouse.devinpharmacy.model.dto;

import com.devinhouse.devinpharmacy.model.Estoque;

import java.time.LocalDateTime;

public record EstoqueResponseCadastroDTO(Long cnpj, Integer nroRegistro, Integer quantidade, LocalDateTime dataAtualizacao) {
    public EstoqueResponseCadastroDTO(Estoque estoque){
        this(estoque.getCnpj(), estoque.getNroRegistro(), estoque.getQuantidade(), estoque.getDataAtualizacao());
    }
}
