package com.devinhouse.devinpharmacy.controller;

import com.devinhouse.devinpharmacy.model.dto.FarmaciaResponseDTO;
import com.devinhouse.devinpharmacy.model.dto.MedicamentoResponseDTO;
import com.devinhouse.devinpharmacy.service.MedicamenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    @Autowired
    private MedicamenteService medicamenteService;

    @GetMapping
    public ResponseEntity<List<MedicamentoResponseDTO>> listAll(){
        List<MedicamentoResponseDTO> response = this.medicamenteService.listAll();
        return ResponseEntity.ok(response);
    }
}
