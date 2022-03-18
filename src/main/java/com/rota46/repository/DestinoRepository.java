package com.rota46.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rota46.model.Destino;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long>{

	List<Destino> findByPromoEquals(String string);

	List<Destino> findByTituloContainingIgnoreCase(String titulo);

	Optional<Destino> findByTitulo(String titulo);

	//Optional<Destino> findByTituloContainingIgnoreCase(String titulo);
}
