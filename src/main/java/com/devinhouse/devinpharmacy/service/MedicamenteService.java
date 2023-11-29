package com.devinhouse.devinpharmacy.service;

import com.devinhouse.devinpharmacy.model.Medicamento;
import com.devinhouse.devinpharmacy.model.dto.MedicamentoRequestDTO;
import com.devinhouse.devinpharmacy.model.dto.MedicamentoResponseDTO;
import com.devinhouse.devinpharmacy.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamenteService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    public MedicamentoResponseDTO create(MedicamentoRequestDTO body){
        Medicamento newMedicamento = this.medicamentoRepository.save(new Medicamento(body));
        return new MedicamentoResponseDTO(newMedicamento);
    }

    public List<MedicamentoResponseDTO> listAll(){
        List<Medicamento> medicamentos = this.medicamentoRepository.findAll();
        return medicamentos.stream().map(MedicamentoResponseDTO::new).toList();
    }


 }
