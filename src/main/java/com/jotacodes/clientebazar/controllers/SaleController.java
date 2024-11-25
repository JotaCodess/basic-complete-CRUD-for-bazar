package com.jotacodes.clientebazar.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jotacodes.clientebazar.dto.SaleDto;
import com.jotacodes.clientebazar.dto.SaleHighestDto;
import com.jotacodes.clientebazar.models.Product;
import com.jotacodes.clientebazar.models.Sale;
import com.jotacodes.clientebazar.repositories.ISaleRepository;

@RestController
@RequestMapping("sales")
public class SaleController {

    @Autowired
    ISaleRepository repository;

    @GetMapping("/higher_sale")
    public ResponseEntity<SaleHighestDto> getSaleWithHighestAmount() {
        // Obtener la venta con el monto más alto
        Optional<Sale> highestSale = repository.findFirstByOrderByTotalAmountDesc();

        if (highestSale.isPresent()) {
            Sale sale = highestSale.get();

            // Crear el DTO con la información de la venta
            SaleHighestDto saleDTO = new SaleHighestDto(
                sale.getSaleCode(),
                sale.getTotal(),
                sale.getProducts().size(),  
                sale.getClient().getName(), 
                sale.getClient().getLastname()  
            );

            return new ResponseEntity<>(saleDTO, HttpStatus.OK);
        } else {
            // Si no hay ventas, devolver un 404
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{date_sale}")
    public ResponseEntity<SaleDto> obtainSalesForDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate sale_Date) {
        
        List<Sale> salesDay = repository.findBySaleDate(sale_Date);

        if (salesDay.isEmpty()) {
            
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        
        int quantTotal = salesDay.size();
        double total = salesDay.stream().mapToDouble(Sale::getTotal).sum();

        
        SaleDto resume = new SaleDto(quantTotal, total);

        return new ResponseEntity<>(resume, HttpStatus.OK);
    }

    @GetMapping
    public List<Sale> findAll(){
        return repository.findAll();
    }

    @GetMapping("/products/{idSale}")
    public ResponseEntity<?> getSaleProducts(@PathVariable Long idSale){
        Optional<Sale> sale = repository.findById(idSale);

        if (sale.isPresent()) {
            
            List<Product> products = sale.get().getProducts(); 
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else {
            
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
