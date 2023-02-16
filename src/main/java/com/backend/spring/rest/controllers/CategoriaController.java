package com.backend.spring.rest.controllers;



import com.backend.spring.rest.models.Categoria;

import com.backend.spring.rest.security.services.ReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(("/api/categorias"))

public class CategoriaController {

    private ReservaService reservaService;

    public CategoriaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_USER')  or hasRole('ROLE_ADMIN')")
    public List<Categoria> getAllCategorias(){
        return reservaService.getAllCategorias();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasRole('ROLE_USER')  or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable("id") long categoriaId){
        return new ResponseEntity<Categoria>(reservaService.getCategoriaById(categoriaId), HttpStatus.OK);
    }
    @PutMapping("{id}")
    @PreAuthorize  hasRole('ROLE_ADMIN')")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable("id") long categoriaId,@RequestBody Categoria categoria){
        return new ResponseEntity<Categoria>(reservaService.updateCategoria(categoria, categoriaId), HttpStatus.OK);}

    @DeleteMapping("{id}")
    @PreAuthorize  hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteCategoriaBy(@PathVariable("id") long categoriaId){
        reservaService.deleteCategoria(categoriaId);
        return new ResponseEntity<String>("Categoria deleted succesfully!.", HttpStatus.OK);
    }

}
