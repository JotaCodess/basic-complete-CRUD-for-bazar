package com.jotacodes.clientebazar.dto;

public class SaleHighestDto {

    private String saleCode;
    private double totalAmount;
    private int productCount;
    private String customerFirstName;
    private String customerLastName;

   
    public SaleHighestDto(String saleCode, double totalAmount, int productCount, String customerFirstName, String customerLastName) {
        this.saleCode = saleCode;
        this.totalAmount = totalAmount;
        this.productCount = productCount;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
    }


    public String getSaleCode() {
        return saleCode;
    }

    public void setSaleCode(String saleCode) {
        this.saleCode = saleCode;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }
}
