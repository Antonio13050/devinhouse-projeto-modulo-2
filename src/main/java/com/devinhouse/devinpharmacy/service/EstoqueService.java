package com.devinhouse.devinpharmacy.service;

import com.devinhouse.devinpharmacy.exception.QuantidadeInformadaMaiorQueQuantidadeEmEstoqueException;
import com.devinhouse.devinpharmacy.exception.RegistroNaoEncontradoException;
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
    public TrocaEstoqueResponseDTO trocaDeMedicamentos(TrocaEstoqueRequestDTO body){

        farmaciaService.cosultarPorCnpj(body.cnpjOrigem());
        farmaciaService.cosultarPorCnpj(body.cnpjDestino());
        medicamenteService.consultarPorNroRegistro(body.nroRegistro());

        Estoque estoqueOrigem = estoqueRepository.findByCnpjAndNroRegistro(body.cnpjOrigem(), body.nroRegistro());
        Estoque estoqueDestino = estoqueRepository.findByCnpjAndNroRegistro(body.cnpjDestino(), body.nroRegistro());

        if (estoqueOrigem == null){
            String cnpjENroRegistroComoString = "cnpj: " + body.cnpjOrigem() + ", nroRegistro: " + body.nroRegistro();
            throw new RegistroNaoEncontradoException("de estoque", cnpjENroRegistroComoString);
        }

        if (estoqueDestino == null){
            String cnpjENroRegistroComoString = "cnpj: " + body.cnpjDestino() + ", nroRegistro: " + body.nroRegistro();
            throw new RegistroNaoEncontradoException("de estoque", cnpjENroRegistroComoString);
        }

        return new TrocaEstoqueResponseDTO(estoqueOrigem, estoqueDestino);
    }

    @Transactional
    public EstoqueResponseCadastroEAtualizacaoDTO atualiza(EstoqueRequestDTO body){

        farmaciaService.cosultarPorCnpj(body.cnpj());
        medicamenteService.consultarPorNroRegistro(body.nroRegistro());

        Estoque registroDeEstoque = estoqueRepository.findByCnpjAndNroRegistro(body.cnpj(), body.nroRegistro());

        if (registroDeEstoque == null){
            String cnpjENroRegistroComoString = "cnpj: " + body.cnpj() + ", nroRegistro: " + body.nroRegistro();
            throw new RegistroNaoEncontradoException("de estoque", cnpjENroRegistroComoString);
        }

        if (registroDeEstoque.getQuantidade() - body.quantidade() < 0){
            throw new QuantidadeInformadaMaiorQueQuantidadeEmEstoqueException("quantidade", registroDeEstoque.getQuantidade());
        }

        if (registroDeEstoque.getQuantidade() - body.quantidade() == 0){

            //atualiza data e hora
            registroDeEstoque.setDataAtualizacao(LocalDateTime.now());
            //atualiza quantidade
            registroDeEstoque.setQuantidade(registroDeEstoque.getQuantidade() - body.quantidade());

            EstoqueResponseCadastroEAtualizacaoDTO newEstoqueResponseCadastroEAtualizacaoDTO = new EstoqueResponseCadastroEAtualizacaoDTO(registroDeEstoque);
            estoqueRepository.delete(registroDeEstoque);
            return newEstoqueResponseCadastroEAtualizacaoDTO;

        }
        //atualiza data e hora
        registroDeEstoque.setDataAtualizacao(LocalDateTime.now());
        //atualiza quantidade
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


