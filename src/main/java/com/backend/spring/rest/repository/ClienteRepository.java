package com.backend.spring.rest.repository;


import com.backend.spring.rest.models.Cliente;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
    public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    }

