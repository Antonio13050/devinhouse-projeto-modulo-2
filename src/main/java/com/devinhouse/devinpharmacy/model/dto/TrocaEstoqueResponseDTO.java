package com.devinhouse.devinpharmacy.model.dto;

import com.devinhouse.devinpharmacy.model.Endereco;
import com.devinhouse.devinpharmacy.model.Estoque;

public record TrocaEstoqueResponseDTO(Integer nroRegistro, Long cnpjOrigem, Integer quantidadeOrigem, Long cnpjDestino, Integer quantidadeDestino) {
    public TrocaEstoqueResponseDTO(Estoque estoqueOrigem, Estoque estoqueDestino) {
        this(estoqueOrigem.getNroRegistro(), estoqueOrigem.getCnpj(), estoqueOrigem.getQuantidade(), estoqueDestino.getCnpj(), estoqueDestino.getQuantidade());

    }
}