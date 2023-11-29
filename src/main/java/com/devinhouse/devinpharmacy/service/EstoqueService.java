package com.devinhouse.devinpharmacy.service;

import com.devinhouse.devinpharmacy.model.Estoque;
import com.devinhouse.devinpharmacy.model.Farmacia;
import com.devinhouse.devinpharmacy.model.dto.EstoqueRequestDTO;
import com.devinhouse.devinpharmacy.model.dto.EstoqueResponseDTO;
import com.devinhouse.devinpharmacy.model.dto.FarmaciaRequestDTO;
import com.devinhouse.devinpharmacy.model.dto.FarmaciaResponseDTO;
import com.devinhouse.devinpharmacy.repository.EstoqueRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Transactional
    public EstoqueResponseDTO create(EstoqueRequestDTO body){
        Estoque newEstoque = this.estoqueRepository.save(new Estoque(body));
        return new EstoqueResponseDTO(newEstoque);
    }

    public List<EstoqueResponseDTO> listAll(){
    List<Estoque> estoque = this.estoqueRepository.findAll();
    return estoque.stream().map(EstoqueResponseDTO::new).toList();
    }
}


