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
    public ResponseEntity<EstoqueResponseCadastroEAtualizacaoDTO> create(@RequestBody @Valid EstoqueRequestDTO body){
        EstoqueResponseCadastroEAtualizacaoDTO response = this.estoqueService.create(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping
    public ResponseEntity<EstoqueResponseCadastroEAtualizacaoDTO> atualizar(@RequestBody @Valid EstoqueRequestDTO body){
        EstoqueResponseCadastroEAtualizacaoDTO response = this.estoqueService.atualiza(body);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping
    public ResponseEntity<TrocaEstoqueResponseDTO> trocaEntreFarmacias(@RequestBody @Valid TrocaEstoqueRequestDTO body){
        TrocaEstoqueResponseDTO response = this.estoqueService.trocaDeMedicamentos(body);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
