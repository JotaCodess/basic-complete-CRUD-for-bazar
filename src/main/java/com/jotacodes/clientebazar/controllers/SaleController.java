package com.jotacodes.clientebazar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

     @PostMapping("create")
    public Sale createClient(@RequestBody Sale sale){
        return repository.save(sale);
    }

     @GetMapping("/{idSale}")
    public ResponseEntity<Sale> obtainProductById(@PathVariable Long idSale){
        return repository.findById(idSale)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("update/{idSale}")
    public ResponseEntity<?> editSale(@PathVariable Long idSale, @RequestBody Sale saleDetails){
        return repository.findById(idSale).map(sale->{
            sale.setClient(saleDetails.getClient());
            sale.setSaleCode(saleDetails.getSaleCode());
            sale.setSaleDate(saleDetails.getSaleDate());
            sale.setTotal(saleDetails.getTotal());
            Sale saleUpdated = repository.save(sale);
            return ResponseEntity.ok(saleUpdated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("delete/{idSale}")
    public ResponseEntity<?> deleteClient(@PathVariable Long idSale){
        return repository.findById(idSale).map(sal ->{
            repository.delete(sal);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
  
}
