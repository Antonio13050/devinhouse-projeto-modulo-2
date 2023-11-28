package com.devinhouse.devinpharmacy.repository;

import com.devinhouse.devinpharmacy.model.Estoque;
import com.devinhouse.devinpharmacy.model.IdEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, IdEstoque> {
}
