package com.jotacodes.clientebazar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jotacodes.clientebazar.models.Sale;
import com.jotacodes.clientebazar.repositories.ISaleRepository;

@RestController
@RequestMapping("sales")
public class SaleController {

    @Autowired
    ISaleRepository repository;

    @GetMapping
    public List<Sale> findAll(){
        return repository.findAll();
    }

  
}
