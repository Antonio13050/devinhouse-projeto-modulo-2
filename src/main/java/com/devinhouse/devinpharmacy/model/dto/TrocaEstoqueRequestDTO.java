package com.devinhouse.devinpharmacy.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TrocaEstoqueRequestDTO(
        @NotNull Long cnpjOrigem,
        @NotNull Long cnpjDestino,

        @NotNull Integer nroRegistro ,
        @Positive(message = "A quantidade deve ser um número positivo.")
        @NotNull Integer quantidade) {
    }