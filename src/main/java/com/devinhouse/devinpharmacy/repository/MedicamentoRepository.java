package com.devinhouse.devinpharmacy.repository;

import com.devinhouse.devinpharmacy.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer> {
}
