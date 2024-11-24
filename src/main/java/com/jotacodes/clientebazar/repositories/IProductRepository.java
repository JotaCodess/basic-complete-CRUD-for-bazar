package com.jotacodes.clientebazar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jotacodes.clientebazar.models.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long>{

}
