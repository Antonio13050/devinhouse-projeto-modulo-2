package com.devinhouse.devinpharmacy.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record EstoqueRequestDTO(@NotNull Long cnpj, @NotNull Integer nroRegistro , @Positive(message = "A quantidade deve ser um número positivo.") @NotNull Integer quantidade) {
}
