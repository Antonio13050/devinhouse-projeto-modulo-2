package com.devinhouse.devinpharmacy.controller;

import com.devinhouse.devinpharmacy.model.Farmacia;
import com.devinhouse.devinpharmacy.model.dto.FarmaciaResponseDTO;
import com.devinhouse.devinpharmacy.service.FarmaciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
