package com.example.customers.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record Customer(
    @NotBlank (message = "El nombre es obligatorio.")String nombre, 
    @NotBlank (message = "El email está vacio, ingresalo.")
    @Email (message = "El email no tiene un formato válido.") String email,
    @Min (value = 0, message = "La edad no puede ser negativa.")
    @Max (value = 120, message = "La edad no puede pasar este valor.") int edad) {}