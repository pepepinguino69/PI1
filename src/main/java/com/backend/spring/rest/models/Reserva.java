package com.backend.spring.rest.models;


import com.backend.spring.rest.payload.request.ReservaRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDateTime;



@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reserva")

public class Reserva {
        @Id
        @Column(name="id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @ManyToOne
        @JoinColumn(
                name = "cliente_id", referencedColumnName = "id",nullable = false,

    foreignKey = @ForeignKey(
            name = "cliente_reserva_fk"
    ))

        @JsonIgnore
        private Cliente cliente;
       @ManyToOne
       @JoinColumn(
               name = "vehiculo_id",
               nullable = false,
               referencedColumnName = "id",
               foreignKey = @ForeignKey(
                       name = "vehiculo_reserva_fk"
               ))
       @JsonIgnore
        private Vehiculo vehiculo;
        @Column(name="comienzo_reserva",nullable = false)
        private LocalDateTime comienzo_reserva;
        @Column(name="fin_reserva",nullable = false)
        private LocalDateTime fin_reserva;


    public Reserva(Cliente cliente, Vehiculo vehiculo, LocalDateTime comienzo_reserva, LocalDateTime fin_reserva) {
        this.id = id;
        this.cliente = Reserva.this.cliente;
        this.vehiculo = vehiculo;
        this.comienzo_reserva = comienzo_reserva;
        this.fin_reserva = fin_reserva;
    }

    public static Reserva from(ReservaRequest reservaRequest){

        Reserva reserva = new Reserva();

        Cliente newCliente=new Cliente();
        reserva.setId(0);
        newCliente.setId(reservaRequest.getCliente_id());
        Vehiculo newVehiculo=new Vehiculo();
        newVehiculo.setId(reservaRequest.getVehiculo_id());
        reserva.setCliente(newCliente);
        reserva.setVehiculo(newVehiculo);
        reserva.setFin_reserva(reservaRequest.getFin_reserva());
        reserva.setComienzo_reserva(reservaRequest.getComienzo_reserva());

        return reserva;Vehiculo

    }

    public String message(Reserva reserva){return   "DR."+reserva.getCliente().getApellido()+" atiende al Sr./a "+
            reserva.getVehiculo().getApellido()+" de "+ reserva.getComienzo_reserva()+" hasta "+
            reserva.getFin_reserva();}
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}



