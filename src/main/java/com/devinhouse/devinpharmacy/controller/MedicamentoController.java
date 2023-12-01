package com.devinhouse.devinpharmacy.controller;

import com.devinhouse.devinpharmacy.model.dto.FarmaciaRequestDTO;
import com.devinhouse.devinpharmacy.model.dto.FarmaciaResponseDTO;
import com.devinhouse.devinpharmacy.model.dto.MedicamentoRequestDTO;
import com.devinhouse.devinpharmacy.model.dto.MedicamentoResponseDTO;
import com.devinhouse.devinpharmacy.service.MedicamenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<MedicamentoResponseDTO> create(@RequestBody @Valid MedicamentoRequestDTO body){
        MedicamentoResponseDTO response = this.medicamenteService.create(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
