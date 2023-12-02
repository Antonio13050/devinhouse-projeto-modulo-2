package com.devinhouse.devinpharmacy.model.dto;

import com.devinhouse.devinpharmacy.model.Farmacia;

public record FarmaciaResponseDTO(Long cnpj, String razaoSocial, String nomeFantasia, String email, String telefone, String celular, EnderecoResponseDTO endereco) {
    public FarmaciaResponseDTO(Farmacia farmacia){
        this(farmacia.getCnpj(), farmacia.getRazaoSocial(), farmacia.getNomeFantasia(), farmacia.getEmail(), farmacia.getTelefone(), farmacia.getCelular(), new EnderecoResponseDTO(farmacia.getEndereco()));
    }
}