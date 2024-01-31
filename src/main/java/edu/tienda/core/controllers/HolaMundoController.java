package edu.tienda.core.controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {

    public String saludo(){
        return "Hola mundo Spring boot nuevo" +
                " 2024";
    }
}
