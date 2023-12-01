package com.devinhouse.devinpharmacy.controller;

import com.devinhouse.devinpharmacy.model.Farmacia;
import com.devinhouse.devinpharmacy.model.dto.FarmaciaRequestDTO;
import com.devinhouse.devinpharmacy.model.dto.FarmaciaResponseDTO;
import com.devinhouse.devinpharmacy.service.FarmaciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmacias")
public class FarmaciaController {

    @Autowired
    private FarmaciaService farmaciaService;

    @GetMapping
    public ResponseEntity<List<FarmaciaResponseDTO>> listAll(){
        List<FarmaciaResponseDTO> response = this.farmaciaService.listAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<FarmaciaResponseDTO> consultarPorCnpj(@PathVariable("cnpj") Long cnpj){
        FarmaciaResponseDTO response = farmaciaService.cosultarPorCnpj(cnpj);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<FarmaciaResponseDTO> create(@RequestBody @Valid FarmaciaRequestDTO body){
        FarmaciaResponseDTO response = this.farmaciaService.create(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

}
