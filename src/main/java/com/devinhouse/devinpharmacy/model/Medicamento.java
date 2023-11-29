package com.devinhouse.devinpharmacy.model;

import com.devinhouse.devinpharmacy.model.dto.MedicamentoRequestDTO;
import com.devinhouse.devinpharmacy.model.enums.TipoMedicamento;
import jakarta.persistence.*;

@Entity
@Table(name = "MEDICAMENTOS")
public class Medicamento {
    @Id
    private Integer nroRegistro;
    private String nome;
    private String laboratorio;
    private String dosagem;
    private String descricao;
    private Float preco;
    @Enumerated(EnumType.STRING)
    private TipoMedicamento tipo;

    public Medicamento() {
    }

    public Medicamento(MedicamentoRequestDTO body) {
        this.nroRegistro = body.nroRegistro();
        this.nome = body.nome();
        this.laboratorio = body.laboratorio();
        this.dosagem = body.dosagem();
        this.descricao = body.descricao();
        this.preco = body.preco();
        this.tipo = body.tipo();
    }

    public Integer getNroRegistro() {
        return nroRegistro;
    }

    public String getNome() {
        return nome;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public String getDosagem() {
        return dosagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public Float getPreco() {
        return preco;
    }

    public TipoMedicamento getTipo() {
        return tipo;
    }
}

