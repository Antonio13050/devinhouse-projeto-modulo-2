package com.devinhouse.devinpharmacy.model;

import com.devinhouse.devinpharmacy.model.dto.EnderecoRequestDTO;
import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {
    private Long cep;
    private String logradouro;
    private Integer numero;
    private String bairro;

    private String cidade;
    private String estado;
    private String complemento;
    private Double latitude;
    private Double longitude;

    public Endereco() {
    }

    public Endereco(EnderecoRequestDTO body) {
        this.cep = body.cep();
        this.logradouro = body.logradouro();
        this.numero = body.numero();
        this.bairro = body.bairro();
        this.cidade = body.cidade();
        this.estado = body.estado();
        this.complemento = body.complemento();
        this.latitude = body.latitude();
        this.longitude = body.longitude();
    }

    public Long getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}

