package com.backend.spring.rest.controllers;

import com.backend.spring.rest.services.TurnoService;
import com.backend.spring.rest.models.Reserva;
import com.backend.spring.rest.payload.request.ReservaRequest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(("/api/turnos"))
public class ReservaController {

    private TurnoService turnoService;

    public ReservaController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }


    @PostMapping()
    public ResponseEntity<String> saveTurno(@RequestBody ReservaRequest turnoRequest) throws Exception {
        Reserva messageValue =turnoService.saveTurno(Reserva.from(turnoRequest));return new ResponseEntity<>(messageValue.message(messageValue) , HttpStatus.CREATED);

                                               //long odontologo_id, long paciente_id, LocalDateTime comienzo_turno, LocalDateTime fin_turno){
       // return new ResponseEntity<Turno>(turnoService.saveTurno(odontologo_id,paciente_id,comienzo_turno,fin_turno), HttpStatus.CREATED);
    };
    @GetMapping
    public List<Reserva> getAllTurnos(){
        return turnoService.getAllTurnos();
    }

    @GetMapping("{id}")
    public ResponseEntity<Reserva> getTurnoById(@PathVariable("id") long turnoId){
        return new ResponseEntity<Reserva>(turnoService.getTurnoById(turnoId), HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Reserva> updateTurno(@PathVariable("id") long turnoId, @RequestBody Reserva turno){
        return new ResponseEntity<Reserva>(turnoService.updateTurno(turno, turnoId), HttpStatus.OK);}

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTurnoBy(@PathVariable("id") long turnoId){
        turnoService.deleteTurno(turnoId);
        return new ResponseEntity<String>("Turno deleted succesfully!.", HttpStatus.OK);
    }

}
