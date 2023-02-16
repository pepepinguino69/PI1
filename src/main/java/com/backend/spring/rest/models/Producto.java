package com.backend.spring.rest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;




@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 65)
    @Column(name = "nombre")
    private String nombre;

    @Size(max = 65)
    @Column(name = "descripcion")
    private String descripcion;

    @NotNull
    @Size(max = 20)
    @Column(unique = true)
    private String patente;

    @NotNull
    private LocalDateTime fecha;
    @OneToMany (cascade = {CascadeType.ALL})
    @JsonIgnore
    private Categoria categoria;

        public Producto(String nombre, String descripcion, String patente, LocalDateTime fecha) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.patente = patente;
        this.fecha = fecha;
    }
    @OneToMany(
            mappedBy = "producto",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    private List<Reserva> turnosPac = new ArrayList<>();



    public void addTurno(Reserva turno) {
        turnosPac.add(turno);
       turno.setPaciente(this);


    }

    public void removeTurno(Reserva turno) {
        turnosPac.add(turno);
        turno.setPaciente(this);
    }


}


