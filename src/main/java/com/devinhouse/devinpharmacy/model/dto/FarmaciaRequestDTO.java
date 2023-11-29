package com.devinhouse.devinpharmacy.model.dto;

import com.devinhouse.devinpharmacy.model.Endereco;

public record FarmaciaRequestDTO(Long cnpj, String razaoSocial, String nomeFantasia, String email, String telefone, String celular, EnderecoRequestDTO endereco) {
}
