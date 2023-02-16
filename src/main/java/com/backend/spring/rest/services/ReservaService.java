package com.backend.spring.rest.services;

import com.backend.spring.rest.models.Categoria;
import com.backend.spring.rest.models.Cliente;
import com.backend.spring.rest.models.Producto;
import com.backend.spring.rest.models.Reserva;
import com.backend.spring.rest.payload.request.ProductoRequest;

import java.util.List;

public interface ReservaService {

    Reserva saveReserva(Reserva reserva) throws Exception;
            //long cliente_id, long producto_id, LocalDateTime comienzo_reserva, LocalDateTime fin_reserva);
    List<Reserva> getAllReservas();
    Reserva getReservaById(long id);
    Reserva updateReserva(Reserva reserva, long id);
    Reserva deleteReserva(long id);
    Cliente saveCliente(Cliente cliente);

    List<Cliente> getAllClientes();

    Cliente getClienteById(long id);

    Cliente updateCliente(Cliente cliente, long id);

    Cliente deleteCliente(long id);
    Producto saveProducto(Producto producto);
    List<Producto> getAllProductos();
    Producto getProductoById(long id);
    Producto updateProducto(Producto producto, long id);
    Producto deleteProducto(long id);

    Categoria saveCategoria(ProductoRequest productoRequest);

    List<Categoria> getAllCategorias();

    Categoria getCategoriaById(long id);

    Categoria updateCategoria(Categoria categoria, long id);

    Categoria deleteCategoria(long id);

}

