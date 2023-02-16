package com.backend.spring.rest.controllers;

import com.backend.spring.rest.models.Producto;
import com.backend.spring.rest.services.TurnoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping(("/api/clientes"))
public class ClienteController {

    private TurnoService turnoService;

    public ClienteController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Producto> saveCliente(@RequestBody Producto cliente){
        return new ResponseEntity<Producto>(turnoService.saveCliente(cliente), HttpStatus.CREATED);
    };

    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ADMIN')")
    public List<Producto> getAllClientes(){
        return turnoService.getAllClientes();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasRole('ROLE_USER')  or hasRole('ADMIN')")
    public ResponseEntity<Producto> getClienteById(@PathVariable("id") long clienteId){
        return new ResponseEntity<Producto>(turnoService.getClienteById(clienteId), HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Producto> updateCliente(@PathVariable("id") long clienteId, @RequestBody Producto cliente){
        return new ResponseEntity<Producto>(turnoService.updateCliente(cliente, clienteId), HttpStatus.OK);}

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteClienteBy(@PathVariable("id") long clienteId){
        turnoService.deleteCliente(clienteId);
        return new ResponseEntity<String>("Cliente deleted succesfully!.", HttpStatus.OK);
    }

}
