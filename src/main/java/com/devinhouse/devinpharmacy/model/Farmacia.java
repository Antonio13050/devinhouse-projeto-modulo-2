package com.devinhouse.devinpharmacy.model;

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
}
