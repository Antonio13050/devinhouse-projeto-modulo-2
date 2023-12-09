package com.devinhouse.devinpharmacy.controller;

import com.devinhouse.devinpharmacy.model.dto.*;
import com.devinhouse.devinpharmacy.service.EstoqueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping
    public ResponseEntity<List<EstoqueResponseDTO>> listAll(){
        List<EstoqueResponseDTO> response = this.estoqueService.listAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<List<EstoqueResponseDTO>> listAllPorCnpj(@PathVariable("cnpj") Long cnpj){
        List<EstoqueResponseDTO> response = this.estoqueService.listAllPorCnpj(cnpj);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<EstoqueResponseCadastroDTO> create(@RequestBody @Valid EstoqueRequestDTO body){
        EstoqueResponseCadastroDTO response = this.estoqueService.create(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
