package com.backend.spring.rest.repository;


import com.backend.spring.rest.models.Categoria;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
