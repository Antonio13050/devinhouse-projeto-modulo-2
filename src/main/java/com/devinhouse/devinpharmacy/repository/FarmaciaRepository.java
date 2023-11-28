package com.devinhouse.devinpharmacy.repository;

import com.devinhouse.devinpharmacy.model.Farmacia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmaciaRepository extends JpaRepository<Farmacia, Long> {
}
