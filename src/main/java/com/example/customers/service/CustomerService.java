package com.example.customers.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.customers.model.Customer;
import com.example.customers.repository.CustomerRepository;

@Service 
public class CustomerService {

    private final CustomerRepository repo; 

    public CustomerService(CustomerRepository repo){
        this.repo = repo;

    } 
    public Customer crear(Customer c){
        return repo.guardar(c);
    }

    public List<Customer> listar(){
        return repo.listar();
    }

}
