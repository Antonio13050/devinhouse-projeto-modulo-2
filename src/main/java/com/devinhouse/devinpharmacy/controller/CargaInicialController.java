package com.devinhouse.devinpharmacy.controller;

import com.devinhouse.devinpharmacy.model.Medicamento;
import com.devinhouse.devinpharmacy.model.dto.EnderecoRequestDTO;
import com.devinhouse.devinpharmacy.model.dto.FarmaciaRequestDTO;
import com.devinhouse.devinpharmacy.model.dto.MedicamentoRequestDTO;
import com.devinhouse.devinpharmacy.model.enums.TipoMedicamento;
import com.devinhouse.devinpharmacy.service.FarmaciaService;
import com.devinhouse.devinpharmacy.service.MedicamenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
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

    @Autowired
    private FarmaciaService farmaciaService;

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

        var farmacias = farmaciaService.listAll();
       // if(farmacias.isEmpty()){

            EnderecoRequestDTO enderecoRequest1 = new EnderecoRequestDTO(88888999L, "Rua Porto Real", 67, "Westeros", "Berlim", "SC", "", 15.23456,  2.8678687);
            FarmaciaRequestDTO farRequest1 = new FarmaciaRequestDTO(90561736000121L, "DevMed Ltda", "Farmácia DevMed", "devmed@farmacia.com", "(44)4444-4444", "(44)9444-4441", enderecoRequest1);

            EnderecoRequestDTO enderecoRequest2 = new EnderecoRequestDTO( 8877799L, "Rua Madrid", 76, "Winterfell", "Estocolmo", "SC", "", 19.254356, 3.8987687);
            FarmaciaRequestDTO farRequest2 = new FarmaciaRequestDTO(43178995000198L, "MedHouse Ltda", "Farmácia MedHouse", "medhouse@farmacia.com", "(55)5555-5555", "(45)95555-5555", enderecoRequest2);

            farmaciaService.create(farRequest1);
            farmaciaService.create(farRequest2);
        //}
        return ResponseEntity.ok().build();
    }
}