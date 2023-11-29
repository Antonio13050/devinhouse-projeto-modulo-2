package com.devinhouse.devinpharmacy.model;

import com.devinhouse.devinpharmacy.model.dto.EnderecoRequestDTO;
import com.devinhouse.devinpharmacy.model.dto.FarmaciaRequestDTO;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "FARMACIAS")
public class Farmacia {
    @Id
    private Long cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String email;
    private String telefone;
    private String celular;
    @Embedded
    private Endereco endereco;

    public Farmacia() {
    }

    public Farmacia(FarmaciaRequestDTO body) {
        this.cnpj = body.cnpj();
        this.razaoSocial = body.razaoSocial();
        this.nomeFantasia = body.nomeFantasia();
        this.email = body.email();
        this.telefone = body.telefone();
        this.celular = body.celular();
        this.endereco = new Endereco(body.endereco());
    }

    public Long getCnpj() {
        return cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCelular() {
        return celular;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
