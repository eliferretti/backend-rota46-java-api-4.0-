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

import com.rota46.model.Destino;
import com.rota46.repository.DestinoRepository;
import com.rota46.repository.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class DestinoController {
	
	@Autowired
	private DestinoRepository destinoRepository;
	
	// lista de destinos
	@GetMapping("/destinos")
	public List<Destino> getAllDestinos(){
	return destinoRepository.findAll();
	}
	
	// lista de destinos em promocao
	@GetMapping("/destinospromo")
	public List<Destino> getAllDestinosPromo(){
	return destinoRepository.findByPromoEquals("SIM");
	}
	
	// consulta destino pelo titulo ou parte dele
	@GetMapping("/destinostitulo/{titulo}")
	public List<Destino> getAllDestinosTitulo(@PathVariable String titulo){
		return destinoRepository.findByTituloContainingIgnoreCase(titulo);
	}
	
	// novo destino rest api
	@PostMapping("/destinos")
	public Destino adicionarDestino(@RequestBody Destino destino) {
	return destinoRepository.save(destino);
	}

	// consulta destino por id
	@GetMapping("/destinos/{id}")
	public ResponseEntity<Destino> consultaDestinoId(@PathVariable Long id){
		Destino destino = destinoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Destino id " + id +" não existe:"));
		return ResponseEntity.ok(destino);
	}
	
	// editar destino rest api
	@PutMapping("/destinos/{id}")
	public ResponseEntity<Destino> updateDestino(@PathVariable Long id, @RequestBody Destino destinoDetails){
		Destino destino = destinoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id + " não foi encontrado."));
	
		destino.setTitulo(destinoDetails.getTitulo());
		destino.setDescricao(destinoDetails.getDescricao());
		destino.setTipo(destinoDetails.getTipo());
		destino.setPromo(destinoDetails.getPromo());
		destino.setPreco(destinoDetails.getPreco());

		Destino updatedDestino = destinoRepository.save(destino);
		return ResponseEntity.ok(updatedDestino);
	}
	
	// delete destino rest api
	@DeleteMapping("/destinos/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDestino(@PathVariable Long id){
		Destino destino = destinoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id + " não foi encontrado."));
		destinoRepository.delete(destino);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
