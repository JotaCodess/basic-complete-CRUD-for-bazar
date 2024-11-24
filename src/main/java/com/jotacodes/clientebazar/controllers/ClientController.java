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
import com.jotacodes.clientebazar.models.Client;
import com.jotacodes.clientebazar.repositories.IClientRepository;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    IClientRepository repository;

    @GetMapping
    public List<Client> findAllClients(){
        return repository.findAll();
    }

    @PostMapping("create")
    public Client createClient(@RequestBody Client client){
        return repository.save(client);
    }

    @PutMapping("update/{idClient}")
    public ResponseEntity<?> editClient(@PathVariable Long idClient, @RequestBody Client clientDetails){
        return repository.findById(idClient).map(clien->{
            clien.setName(clientDetails.getName());
            clien.setLastname(clientDetails.getLastname());
            clien.setDni(clientDetails.getDni());
            Client clientUpdated = repository.save(clien);
            return ResponseEntity.ok(clientUpdated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("delete/{idClient}")
    public ResponseEntity<?> deleteClient(@PathVariable Long idClient){
        return repository.findById(idClient).map(clien ->{
            repository.delete(clien);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
