package com.devinhouse.devinpharmacy.controller;

import com.devinhouse.devinpharmacy.model.Medicamento;
import com.devinhouse.devinpharmacy.model.dto.MedicamentoRequestDTO;
import com.devinhouse.devinpharmacy.model.enums.TipoMedicamento;
import com.devinhouse.devinpharmacy.service.MedicamenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inicializacao")
public class CargaInicialController {

    @Autowired
    private MedicamenteService medicamenteService;

    @PostMapping
    public ResponseEntity<?> cargaInicial(){
        var medicamentos = medicamenteService.listAll();
        if (medicamentos.isEmpty()){
            MedicamentoRequestDTO medRequest1 = new MedicamentoRequestDTO(1010, "Programapan", "Matrix", "2x ao dia", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc eleifend",111.00F, TipoMedicamento.COMUM);
            MedicamentoRequestDTO medRequest2 = new MedicamentoRequestDTO(7473, "Cafex", "Colombia Farm", "4x ao dia", "Pellentesque non ultricies mauris, ut lobortis elit. Cras nec cursus nibh",51.50F, TipoMedicamento.COMUM);
            MedicamentoRequestDTO medRequest3 = new MedicamentoRequestDTO(2233, "Estomazol", "Acme", "1x ao dia", "Sed risus mauris, consectetur eget egestas vitae",22.50F, TipoMedicamento.COMUM);
            MedicamentoRequestDTO medRequest4 = new MedicamentoRequestDTO(8880, "Gelox", "Ice", "2x ao dia", "Quisque quam orci, vulputate sit amet",11.50F, TipoMedicamento.COMUM);
            MedicamentoRequestDTO medRequest5 = new MedicamentoRequestDTO(5656, "Aspirazol", "Acme", "3x ao dia", "Sed faucibus, libero iaculis pulvinar consequat, augue elit eleifend",10.50F, TipoMedicamento.CONTROLADO);
            MedicamentoRequestDTO medRequest6 = new MedicamentoRequestDTO(4040, "Propolizol", "Bee", "5x ao dia", "Nunc euismod ipsum purus, sit amet finibus libero ultricies in",10.50F, TipoMedicamento.CONTROLADO);

            medicamenteService.create(medRequest1);
            medicamenteService.create(medRequest2);
            medicamenteService.create(medRequest3);
            medicamenteService.create(medRequest4);
            medicamenteService.create(medRequest5);

        }
        return ResponseEntity.ok().build();
    }
}