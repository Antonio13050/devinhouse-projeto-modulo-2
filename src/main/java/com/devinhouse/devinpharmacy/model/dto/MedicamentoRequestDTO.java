package com.devinhouse.devinpharmacy.model.dto;

import com.devinhouse.devinpharmacy.model.enums.TipoMedicamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicamentoRequestDTO(@NotNull Integer nroRegistro, @NotBlank String nome, @NotBlank String laboratorio, @NotBlank String dosagem, String descricao, @NotNull Float preco, @NotNull TipoMedicamento tipo) {
}
