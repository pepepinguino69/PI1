package com.backend.spring.rest.controllers;



import com.backend.spring.rest.models.Categoria;
import com.backend.spring.rest.models.Producto;
import com.backend.spring.rest.payload.request.ProductoRequest;
import com.backend.spring.rest.services.TurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(("/api/pacientes"))

public class ProductoController {

    private TurnoService turnoService;

    public ProductoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }


    @PostMapping("/")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Producto> saveDomicilio(@RequestBody ProductoRequest pacienteRequest){
        Categoria savedDomicilio = turnoService.saveDomicilio(pacienteRequest);
      ;return new ResponseEntity<Producto>(turnoService.getPacienteById(savedDomicilio.getId()), HttpStatus.CREATED);
    };
    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public List<Producto> getAllPacientes(){
        return turnoService.getAllPacientes();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Producto> getPacienteById(@PathVariable("id") long pacienteId){
        return new ResponseEntity<Producto>(turnoService.getPacienteById(pacienteId), HttpStatus.OK);
    }
    @PutMapping("{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Producto> updatePaciente(@PathVariable("id") long pacienteId, @RequestBody Producto paciente){
        return new ResponseEntity<Producto>(turnoService.updatePaciente(paciente, pacienteId), HttpStatus.OK);}

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePacienteBy(@PathVariable("id") long pacienteId){
        turnoService.deletePaciente(pacienteId);
        return new ResponseEntity<String>("Paciente deleted succesfully!.", HttpStatus.OK);
    }

}
