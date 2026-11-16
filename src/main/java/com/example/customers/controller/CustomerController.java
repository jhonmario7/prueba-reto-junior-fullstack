package com.example.customers.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.customers.model.Customer;
import com.example.customers.service.CustomerService;

@RestController 
@RequestMapping ("/api/customers") //ruta
public class CustomerController {

    // campo private final del CustomerService + constructor
    private final CustomerService service;

    public CustomerController(CustomerService service){
        this.service = service;
    }
    //--

    //método para POST que reciba un Customer y devuelva 201 Created
    @PostMapping 
    public ResponseEntity<Customer> crear(@RequestBody Customer c){
        Customer creado = service.crear(c);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
    //--

    //método para GET que devuelva la lista de Customer
    @GetMapping 
    public List<Customer> listar(){
        return service.listar();
    }
    //--
}
