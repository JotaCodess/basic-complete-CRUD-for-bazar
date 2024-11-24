package com.jotacodes.clientebazar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jotacodes.clientebazar.models.Sale;

public interface ISaleRepository extends JpaRepository<Sale,Long>{

}
