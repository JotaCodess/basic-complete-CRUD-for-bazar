package com.jotacodes.clientebazar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long productCode;
    
    String name;
    String brand; //marca
    Double cost;
    Double quantityAvaible;

    public Long getProductCode() {
        return productCode;
    }
    public void setProductCode(Long productCode) {
        this.productCode = productCode;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public Double getCost() {
        return cost;
    }
    public void setCost(Double cost) {
        this.cost = cost;
    }
    public Double getQuantityAvaible() {
        return quantityAvaible;
    }
    public void setQuantityAvaible(Double quantityAvaible) {
        this.quantityAvaible = quantityAvaible;
    }

    
}
