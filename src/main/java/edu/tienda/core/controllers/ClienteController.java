package edu.tienda.core.controllers;

import edu.tienda.core.domain.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    private List<Cliente> clientes = new ArrayList<>(Arrays.asList(
            new Cliente("arm","1234","Armstrong"),
            new Cliente("ald","1234","Armstrong"),
            new Cliente("col","1234","Armstrong")
        )
    );

    @GetMapping("/clientes")
    public List<Cliente> getCLientes(){
        return clientes;
    }

    @GetMapping("/clientes/{username}")
    public Cliente getCliente(@PathVariable String username){
        for(Cliente cli: clientes){
            if(cli.getUsername().equalsIgnoreCase(username)){
                return cli;
            }
        }
        return null;
    }

    @GetMapping("/cliente/{username}")
    public Cliente getClienteUsername(@PathVariable String username){
        return clientes.stream().
                filter(cliente->cliente.getUsername().equalsIgnoreCase(username)).
                findFirst().orElseThrow();
    }

    @PostMapping("/clientes")
    public Cliente altaCliente(@RequestBody Cliente cliente){
        clientes.add(cliente);
        return cliente;
    }

    @PutMapping("/clientes")
    public Cliente modificarCliente(@RequestBody Cliente cliente){
        Cliente clienteEncontrado = clientes.stream().
                filter(cli->cli.getUsername().equalsIgnoreCase(cliente.getUsername())).
                findFirst().orElseThrow();

        clienteEncontrado.setPassword(cliente.getPassword());
        clienteEncontrado.setNombre(cliente.getNombre());

        return clienteEncontrado;
    }


    @DeleteMapping("/clientes/{username}")
    public void eliminarCliente(@PathVariable String username){
        Cliente clienteEncontrado = clientes.stream().
                filter(cli->cli.getUsername().equalsIgnoreCase(username)).
                findFirst().orElseThrow();

        clientes.remove(clienteEncontrado);
    }

}
