package edu.tienda.core.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {

    @GetMapping("/saludo")
    public String saludo(){
        return "Hola mundo Spring boot nuevo" +
                " 2024" +
                " ultimo cambio";
    }
}
