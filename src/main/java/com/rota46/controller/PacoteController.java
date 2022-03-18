package com.rota46.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rota46.model.Pacote;
import com.rota46.repository.PacoteRepository;
import com.rota46.repository.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class PacoteController {
	
	@Autowired
	private PacoteRepository pacoteRepository;
	
	// lista de pacote
	@GetMapping("/pacotes")
	public List<Pacote> getAllPacotes(){
	return pacoteRepository.findAll();
	}
	
	// novo pacote rest api
	@PostMapping("/pacotes")
	public Pacote adicionarPacote(@RequestBody Pacote pacote) {
	return pacoteRepository.save(pacote);
	}
	
	// consulta pacote por id
	@GetMapping("/pacotes/{id}")
	public ResponseEntity<Pacote> consultaPacoteId(@PathVariable Long id){
		Pacote pacote = pacoteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pacote id " + id +" não existe:"));
		return ResponseEntity.ok(pacote);
	}
	
	// editar pacote rest api
	@PutMapping("/pacotes/{id}")
	public ResponseEntity<Pacote> updatePacote(@PathVariable Long id, @RequestBody Pacote pacoteDetails){
		Pacote pacote = pacoteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pacote Id" + id + " não foi encontrado."));
	
		pacote.setDataCompra(pacoteDetails.getDataCompra());
		pacote.setDataViagem(pacoteDetails.getDataViagem());
		pacote.setPreco(pacoteDetails.getPreco());
		pacote.setCliente(pacoteDetails.getCliente());
		pacote.setDestino(pacoteDetails.getDestino());

		Pacote updatedPacote = pacoteRepository.save(pacote);
		return ResponseEntity.ok(updatedPacote);
	}
	
	// delete pacote rest api
	@DeleteMapping("/pacotes/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePacote(@PathVariable Long id){
		Pacote pacote = pacoteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pacote Id " + id + " não foi encontrado."));
		pacoteRepository.delete(pacote);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
