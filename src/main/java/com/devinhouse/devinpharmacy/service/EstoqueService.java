package com.devinhouse.devinpharmacy.service;

import com.devinhouse.devinpharmacy.model.Estoque;
import com.devinhouse.devinpharmacy.model.dto.*;
import com.devinhouse.devinpharmacy.repository.EstoqueRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private MedicamenteService medicamenteService;

    @Autowired
    private FarmaciaService farmaciaService;

    @Transactional
    public EstoqueResponseCadastroEAtualizacaoDTO create(EstoqueRequestDTO body) {

        farmaciaService.cosultarPorCnpj(body.cnpj());
        medicamenteService.consultarPorNroRegistro(body.nroRegistro());

        Estoque registroExistente = estoqueRepository.findByCnpjAndNroRegistro(body.cnpj(), body.nroRegistro());

        if (registroExistente == null){
            Estoque newEstoque = this.estoqueRepository.save(new Estoque(body));
            return new EstoqueResponseCadastroEAtualizacaoDTO(newEstoque);
        }

        registroExistente.setDataAtualizacao(LocalDateTime.now());
        registroExistente.setQuantidade(registroExistente.getQuantidade() + body.quantidade());

        return new EstoqueResponseCadastroEAtualizacaoDTO(registroExistente);
    }

    @Transactional
    public EstoqueResponseCadastroEAtualizacaoDTO atualiza(EstoqueRequestDTO body){

        farmaciaService.cosultarPorCnpj(body.cnpj());
        medicamenteService.consultarPorNroRegistro(body.nroRegistro());

        Estoque registroDeEstoque = estoqueRepository.findByCnpjAndNroRegistro(body.cnpj(), body.nroRegistro());

        registroDeEstoque.setDataAtualizacao(LocalDateTime.now());
        registroDeEstoque.setQuantidade(registroDeEstoque.getQuantidade() - body.quantidade());

        return new EstoqueResponseCadastroEAtualizacaoDTO(registroDeEstoque);
    }

    public List<EstoqueResponseDTO> listAll(){
    List<Estoque> estoque = this.estoqueRepository.findAll();
    return estoque.stream().map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public List<EstoqueResponseDTO> listAllPorCnpj(Long cnpj){

        //verifica se possui farmacia cadastrada com cnpj informado
        farmaciaService.cosultarPorCnpj(cnpj);

        List<Estoque> estoque = estoqueRepository.findByCnpj(cnpj);
        return estoque.stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private EstoqueResponseDTO convertToDTO(Estoque estoque) {
        EstoqueResponseDTO estoqueResponseDTO = new EstoqueResponseDTO();

        String nome = medicamenteService.buscarNomeMedicamento(estoque.getNroRegistro());

        estoqueResponseDTO.setNroRegistro(estoque.getNroRegistro());
        estoqueResponseDTO.setNome(nome);
        estoqueResponseDTO.setQuantidade(estoque.getQuantidade());
        estoqueResponseDTO.setDataAtualizacao(estoque.getDataAtualizacao());

        return estoqueResponseDTO;
    }
}


