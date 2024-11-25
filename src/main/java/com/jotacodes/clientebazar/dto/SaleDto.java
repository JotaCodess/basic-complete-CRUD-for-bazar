package com.jotacodes.clientebazar.dto;

public class SaleDto {
    
    private int quantSales;
    private double sumTotal;

    public SaleDto(int quantSales, double total) {
        this.quantSales = quantSales;
        this.sumTotal = total;
    }

    public int getQuantSales() {
        return quantSales;
    }

    public void setQuantSales(int quantSales) {
        this.quantSales = quantSales;
    }

    public double getSumTotal() {
        return sumTotal;
    }

    public void setSumTotal(double total) {
        this.sumTotal = total;
    }
}
