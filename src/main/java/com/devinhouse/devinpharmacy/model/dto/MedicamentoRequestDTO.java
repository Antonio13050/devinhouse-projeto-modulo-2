package com.devinhouse.devinpharmacy.model.dto;

import com.devinhouse.devinpharmacy.model.enums.TipoMedicamento;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record MedicamentoRequestDTO(Integer nroRegistro, String nome, String laboratorio, String dosagem, String descricao, Float preco, TipoMedicamento tipo) {
}
