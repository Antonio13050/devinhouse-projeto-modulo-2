package com.devinhouse.devinpharmacy.model;

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
}

