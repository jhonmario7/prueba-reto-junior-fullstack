package com.example.customers.repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.example.customers.exception.CustomerAlreadyExistsException;
import com.example.customers.model.Customer;

@Repository
public class CustomerRepository {

    private final ConcurrentHashMap<String, Customer> datos = new ConcurrentHashMap<>();

    public Customer guardar(Customer c) {
        // putIfAbsent: "guardar solo si no existe" en un solo paso, para que dos 
        // POST simultáneos no dejen pasar el duplicado
        Customer previo = datos.putIfAbsent(c.email(), c);
        if (previo != null){
            throw new CustomerAlreadyExistsException(c.email());
        }
        return c;
    }

    public List<Customer> listar() {
        return List.copyOf(datos.values());
    }
}