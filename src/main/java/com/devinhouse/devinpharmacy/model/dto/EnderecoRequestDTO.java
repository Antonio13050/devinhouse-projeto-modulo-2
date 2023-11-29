package com.devinhouse.devinpharmacy.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EnderecoRequestDTO(Long cep, String logradouro, Integer numero, String bairro, String cidade, String estado, String complemento, Double latitude, Double longitude) {
}
