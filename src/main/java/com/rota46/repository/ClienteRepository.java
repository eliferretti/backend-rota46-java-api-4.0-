package com.rota46.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rota46.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	List<Cliente> findByNomeContainingIgnoreCase(String nome);

	/*
	List<Cliente> findByNomeContainingIgnoreCase(String nome);
	*/	
}
