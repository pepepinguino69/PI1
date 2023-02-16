package com.backend.spring.rest.services;

import com.backend.spring.rest.models.Categoria;
import com.backend.spring.rest.repository.ClienteRepository;
import com.backend.spring.rest.repository.ProductoRepository;
import com.backend.spring.rest.repository.ReservaRepository;
import com.backend.spring.rest.exception.ResourceNotFoundException;
import com.backend.spring.rest.models.Cliente;
import com.backend.spring.rest.models.Producto;
import com.backend.spring.rest.models.Reserva;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservaServiceImpl implements ReservaService {

    public ReservaRepository reservaRepository;
    private ClienteRepository clienteRepository;
    private ProductoRepository productoRepository;

    private CastegoriaRepository categoriaRepository;


    public ReservaServiceImpl(ReservaRepository reservaRepository, ClienteRepository clienteRepository,
                              ProductoRepository productoRepository, CastegoriaRepository categoriaRepository) {
                this.reservaRepository = reservaRepository;
                this.clienteRepository = clienteRepository;
                this.productoRepository = productoRepository;
                this.categoriaRepository = categoriaRepository;

    }

    @Override
    public Reserva saveReserva(Reserva reserva) throws Exception {


        reserva.setProducto(getProductoById(reserva.getProducto().getId()));
        reserva.setCliente(getClienteById(reserva.getCliente().getId()));
        reserva.getCliente().addReserva(reserva);
        reserva.getProducto().addReserva(reserva);
        return reservaRepository.save(reserva);
    }
    @Override
    public List<Reserva> getAllReservas(){
        return reservaRepository.findAll();
    }
    @Override
    public Reserva getReservaById(long id){
        return reservaRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Reserva","id",id));
    }
    @Override
    public Reserva updateReserva(Reserva reserva, long id){
        Reserva existingReserva= reservaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reserva","id",id));
        existingReserva.setCliente(reserva.getCliente());
        existingReserva.setProducto(reserva.getProducto());
        existingReserva.setComienzo_reserva(reserva.getComienzo_reserva());
        existingReserva.setFin_reserva(reserva.getFin_reserva());
        reservaRepository.save(existingReserva);
        return existingReserva;
    }
    @Override
    public Reserva deleteReserva(long id){
        Reserva existingReserva= reservaRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Reserva","id",id));
        reservaRepository.deleteById(id);
        return existingReserva;


    }
    @Override
    public Cliente saveCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }
    @Override
    public List<Cliente> getAllClientes(){
        return clienteRepository.findAll();
    }
    @Override
    public Cliente getClienteById(long id){
        return clienteRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Cliente","id",id));
    }
    @Override
    public Cliente updateCliente(Cliente cliente, long id){
        Cliente existingCliente= clienteRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Cliente","id",id));
        existingCliente.setNombre(cliente.getNombre());
        existingCliente.setApellido(cliente.getApellido());
        existingCliente.setMatricula(cliente.getMatricula());
        clienteRepository.save(existingCliente);
        return existingCliente;


    }
    @Override
    public Cliente deleteCliente(long id){
        Cliente existingCliente= clienteRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Cliente","id",id));
        clienteRepository.deleteById(id);
        return existingCliente;


    }


    @Override
    public Producto saveProducto(Producto producto){
        return productoRepository.save(producto);
    }
    @Override
    public List<Producto> getAllProductos(){
        return productoRepository.findAll();
    }
    @Override
    public Producto getProductoById(long id){
        return productoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Producto","id",id));
    }
    @Override
    public Producto updateProducto(Producto producto, long id){
        Producto existingProducto= productoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Producto","id",id));
        existingProducto.setNombre(producto.getNombre());
        existingProducto.setApellido(producto.getApellido());
        existingProducto.setCastegoria(producto.getCastegoria());
        existingProducto.setDni(producto.getDni());
        existingProducto.setFecha(producto.getFecha());
        productoRepository.save(existingProducto);
        return existingProducto;

    }
    @Override
    public Producto deleteProducto(long id){
        Producto existingProducto= productoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Producto","id",id));
        productoRepository.deleteById(id);
        return existingProducto;}

        @Override
        public Categoria saveCastegoria(ProductoRequest productoRequest){

            Producto producto = new Producto();
            producto.setNombre(productoRequest.getNombre());
            producto.setApellido(productoRequest.getApellido());
            producto.setDni(productoRequest.getDni());
            producto.setFecha(productoRequest.getFecha());
            Categoria categoria = new Categoria();
            categoria.setCalle(productoRequest.getCalle());
            categoria.setLocalidad(productoRequest.getLocalidad());
            categoria.setCiudad(productoRequest.getCiudad());
            producto.setCastegoria(categoria);
            categoria.setProducto(producto);
            productoRepository.save(producto);
            return categoria;
        }
        @Override
        public List<Categoria> getAllCastegorias(){
            return categoriaRepository.findAll();
        }
        @Override
        public Categoria getCastegoriaById(long id){
            return categoriaRepository.findById(id).orElseThrow(() ->
                    new ResourceNotFoundException("Castegoria","id",id));
        }
        @Override
        public Categoria updateCastegoria(Categoria categoria, long id){
            Categoria existingCastegoria= categoriaRepository.findById(id).orElseThrow(() ->
                    new ResourceNotFoundException("Producto","id",id));
            existingCastegoria.setCalle(categoria.getCalle());
            existingCastegoria.setLocalidad(categoria.getLocalidad());
            existingCastegoria.setCiudad(categoria.getCiudad());
            categoriaRepository.save(existingCastegoria);
            return existingCastegoria;


        }
        @Override
        public Categoria deleteCastegoria(long id){
            Categoria existingCastegoria= categoriaRepository.findById(id).orElseThrow(() ->
                    new ResourceNotFoundException("Castegoria","id",id));
            categoriaRepository.deleteById(id);
            return existingCastegoria;


        }






}

