package com.devinhouse.devinpharmacy.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoRequestDTO(@NotNull Long cep, @NotBlank String logradouro, @NotNull Integer numero, @NotBlank String bairro, @NotBlank String cidade, @NotBlank String estado, String complemento, @NotNull Double latitude, @NotNull Double longitude) {
}
