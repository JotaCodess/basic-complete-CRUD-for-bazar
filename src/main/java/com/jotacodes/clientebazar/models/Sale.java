package com.jotacodes.clientebazar.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToMany
    private List<Product> products;
    
    @ManyToOne
    @JoinColumn(name = "id_client")
    Client client;
    
    private LocalDate saleDate;
    private Double total;
    private String saleCode;

    
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long saleCode) {
        this.id = saleCode;
    }
    public LocalDate getSaleDate() {
        return saleDate;
    }
    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }
    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }
    public String getSaleCode() {
        return saleCode;
    }
    public void setSaleCode(String saleCode) {
        this.saleCode = saleCode;
    }
}
