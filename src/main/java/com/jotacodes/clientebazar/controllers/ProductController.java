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

import com.jotacodes.clientebazar.models.Product;
import com.jotacodes.clientebazar.repositories.IProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductRepository repository;

    @GetMapping
    public List<Product> listProducts(){
        return repository.findAll();
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product){
        return repository.save(product);
    }

    @GetMapping("/{idProduct}")
    public ResponseEntity<Product> obtainProductById(@PathVariable Long idProduct){
        return repository.findById(idProduct)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{idProduct}")
    public ResponseEntity<Product> editProduct(@PathVariable Long idProduct, @RequestBody Product productDetails){
        
        return repository.findById(idProduct).map(prod ->{
            prod.setName(productDetails.getName());
            prod.setBrand(productDetails.getBrand());
            prod.setCost(productDetails.getCost());
            prod.setQuantityAvaible(productDetails.getQuantityAvaible());
            Product updateProduct = repository.save(prod);
            return ResponseEntity.ok(updateProduct);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{idProduct}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long idProduct){
        return repository.findById(idProduct).map(prod -> {
            repository.delete(prod);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
    
}
