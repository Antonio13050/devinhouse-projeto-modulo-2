package com.devinhouse.devinpharmacy.model.dto;

import com.devinhouse.devinpharmacy.model.Endereco;

public record EnderecoResponseDTO(Long cep, String logradouro, Integer numero, String bairro, String cidade, String estado, String complemento, Double latitude, Double longitude ) {
    public EnderecoResponseDTO(Endereco endereco){
        this(endereco.getCep(), endereco.getLogradouro(), endereco.getNumero(), endereco.getBairro(), endereco.getCidade(), endereco.getEstado(), endereco.getComplemento(), endereco.getLatitude(), endereco.getLongitude());
    }
}
