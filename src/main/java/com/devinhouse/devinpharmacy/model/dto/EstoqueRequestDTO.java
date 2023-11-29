package com.devinhouse.devinpharmacy.model.dto;

import jakarta.persistence.Id;

public record EstoqueRequestDTO(Long cnpj, Integer nroRegistro, Integer quantidade) {
}
