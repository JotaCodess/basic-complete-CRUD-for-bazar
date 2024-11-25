package com.jotacodes.clientebazar.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jotacodes.clientebazar.models.Sale;

public interface ISaleRepository extends JpaRepository<Sale,Long>{

    List<Sale> findBySaleDate(LocalDate saleDate);

    Optional<Sale> findFirstByOrderByTotalAmountDesc();
}
