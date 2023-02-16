package com.backend.spring.rest.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "odontologo")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellido", nullable = false)
    private String apellido;
    @Column(name = "matricula", nullable = false, unique = true)
    private String matricula;
    @OneToMany(
            mappedBy = "odontologo",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    private List<Reserva> reservasOdo = new ArrayList<>();


    public void addTurno(Reserva reserva) {
        reservasOdo.add(reserva);
        reserva.setCliente(this);
    }

    public void removeTurno(Reserva reserva) {
        reservasOdo.add(reserva);
        reserva.setCliente(this);
    }
}


