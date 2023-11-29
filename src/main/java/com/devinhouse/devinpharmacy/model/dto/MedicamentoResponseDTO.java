package com.devinhouse.devinpharmacy.model.dto;

import com.devinhouse.devinpharmacy.model.Medicamento;
import com.devinhouse.devinpharmacy.model.enums.TipoMedicamento;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record MedicamentoResponseDTO (Integer registro, String nome, String laboratorio, String dosagem, String descricao, Float preco, TipoMedicamento tipo){
    public MedicamentoResponseDTO(Medicamento medicamento){
        this(medicamento.getNroRegistro(), medicamento.getNome(), medicamento.getLaboratorio(), medicamento.getDosagem(), medicamento.getDescricao(), medicamento.getPreco(), medicamento.getTipo());
    }
}