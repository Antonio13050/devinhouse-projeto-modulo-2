package com.devinhouse.devinpharmacy.model.dto;

import com.devinhouse.devinpharmacy.model.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FarmaciaRequestDTO(@NotNull Long cnpj, @NotBlank String razaoSocial, @NotBlank String nomeFantasia, @NotBlank String email, String telefone, @NotBlank String celular, @NotNull @Valid EnderecoRequestDTO endereco) {
}
