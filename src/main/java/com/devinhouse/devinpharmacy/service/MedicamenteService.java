package com.devinhouse.devinpharmacy.service;

import com.devinhouse.devinpharmacy.exception.RegistroJaExistenteException;
import com.devinhouse.devinpharmacy.exception.RegistroNaoEncontradoException;
import com.devinhouse.devinpharmacy.model.Farmacia;
import com.devinhouse.devinpharmacy.model.Medicamento;
import com.devinhouse.devinpharmacy.model.dto.FarmaciaRequestDTO;
import com.devinhouse.devinpharmacy.model.dto.FarmaciaResponseDTO;
import com.devinhouse.devinpharmacy.model.dto.MedicamentoRequestDTO;
import com.devinhouse.devinpharmacy.model.dto.MedicamentoResponseDTO;
import com.devinhouse.devinpharmacy.repository.MedicamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamenteService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Transactional
    public MedicamentoResponseDTO create(MedicamentoRequestDTO body){
        boolean existe = medicamentoRepository.existsById(body.nroRegistro());
        if(existe){
            throw new RegistroJaExistenteException("Medicamento", body.nroRegistro());
        }
        Medicamento newMedicamento = this.medicamentoRepository.save(new Medicamento(body));
        return new MedicamentoResponseDTO(newMedicamento);
    }

    public List<MedicamentoResponseDTO> listAll(){
        List<Medicamento> medicamentos = this.medicamentoRepository.findAll();
        return medicamentos.stream().map(MedicamentoResponseDTO::new).toList();
    }

    public String buscarNomeMedicamento(Integer nroRegistro){
        Medicamento medicamento = medicamentoRepository.findById(nroRegistro)
                .orElseThrow(()-> new RegistroNaoEncontradoException("Medicamento", nroRegistro));
        String nome = medicamento.getNome();
        return nome;
    }

    public MedicamentoResponseDTO consultarPorNroRegistro(Integer nroRegistro){
        return this.medicamentoRepository.findById(nroRegistro).map(MedicamentoResponseDTO::new)
                .orElseThrow(() -> new RegistroNaoEncontradoException("de medicamento", nroRegistro));
    }
 }
