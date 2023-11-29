package com.devinhouse.devinpharmacy.service;

import com.devinhouse.devinpharmacy.model.Farmacia;
import com.devinhouse.devinpharmacy.model.Medicamento;
import com.devinhouse.devinpharmacy.model.dto.FarmaciaRequestDTO;
import com.devinhouse.devinpharmacy.model.dto.FarmaciaResponseDTO;
import com.devinhouse.devinpharmacy.model.dto.MedicamentoRequestDTO;
import com.devinhouse.devinpharmacy.model.dto.MedicamentoResponseDTO;
import com.devinhouse.devinpharmacy.repository.FarmaciaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmaciaService {

    @Autowired
    private FarmaciaRepository farmaciaRepository;

    @Transactional
    public FarmaciaResponseDTO create(FarmaciaRequestDTO body){
        Farmacia newFarmacia = this.farmaciaRepository.save(new Farmacia(body));
        return new FarmaciaResponseDTO(newFarmacia);
    }

    public List<FarmaciaResponseDTO> listAll(){
        List<Farmacia> farmacias = this.farmaciaRepository.findAll();
        return farmacias.stream().map(FarmaciaResponseDTO::new).toList();
    }
}
