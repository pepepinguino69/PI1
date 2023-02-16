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
@Table(name = "vehiculo")
public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 65)
    @Column(name = "idproducto")
    private Long idproducto;


    @NotNull
    @Size(max = 20)
    @Column(unique = true)
    private String patente;

    @ManyToOne
    @JoinColumn(
            name = "paciente_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "paciente_turno_fk"
            ))
    @JsonIgnore

    public Producto(String nombre, String descripcion, String patente, LocalDateTime fecha) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.patente = patente;
        this.fecha = fecha;
    }
    @OneToMany(
            mappedBy = "vehiculo",
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


