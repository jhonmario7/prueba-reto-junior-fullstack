package com.example.customers.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController 
@RequestMapping ("/api/info")
public class InfoController {
    
    private final Environment env;

    // Si no hay app.mensaje (sin perfil),
    // se usa el texto después de ":"
    @Value ("${app.mensaje:Sin perfil activo}")

    private String mensaje;

    public InfoController(Environment env){
        this.env = env;
    }

    @GetMapping
    public Map<String, Object> info(){
        return Map.of(
            "app", env.getProperty("spring.application.name"),
            "mensaje", mensaje,
            //devuelve un arreglo de texto
            "perfiles", env.getActiveProfiles()
        );
    }
    

}
