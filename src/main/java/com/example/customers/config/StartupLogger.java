package com.example.customers.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component 
public class StartupLogger {
    
    private static final Logger log = LoggerFactory.getLogger(StartupLogger.class);
    

    private final Environment env; 

    // Si no hay app.mensaje (sin perfil), 
    // se usa el texto después de ":"
    @Value ("${app.mensaje:Sin perfil activo}")

    private String mensaje;

    public StartupLogger(Environment env){
        this.env = env;
    }

    // Se escribe al evento "app lista" y no en el constructor, 
    // para que el puerto ya esté abierto
    @EventListener (ApplicationReadyEvent.class)

    public void alArrancar(){
        log.info("{} | app={} | puerto={} | perfiles={}",
            mensaje,
            env.getProperty("spring.application.name"),
            env.getProperty("server.port"),
            String.join(",", env.getActiveProfiles()));
    }
}
