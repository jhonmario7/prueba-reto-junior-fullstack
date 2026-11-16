package com.example.customers.repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.example.customers.model.Customer;

@Repository
public class CustomerRepository {

    private final ConcurrentHashMap<String, Customer> datos = new ConcurrentHashMap<>();

    public Customer guardar(Customer c) {
        datos.put(c.email(), c);
        return c;
    }

    public List<Customer> listar() {
        return List.copyOf(datos.values());
    }
}