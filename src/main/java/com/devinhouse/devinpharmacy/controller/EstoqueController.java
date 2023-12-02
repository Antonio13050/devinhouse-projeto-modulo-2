package com.devinhouse.devinpharmacy.controller;

import com.devinhouse.devinpharmacy.model.dto.EstoqueResponseDTO;
import com.devinhouse.devinpharmacy.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
