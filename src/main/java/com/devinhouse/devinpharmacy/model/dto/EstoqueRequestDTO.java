package com.devinhouse.devinpharmacy.model.dto;

import jakarta.validation.constraints.NotNull;

public record EstoqueRequestDTO(@NotNull Long cnpj, @NotNull Integer nroRegistro, @NotNull Integer quantidade) {
}
