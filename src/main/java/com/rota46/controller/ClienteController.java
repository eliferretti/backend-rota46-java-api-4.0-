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
import com.rota46.repository.ClienteRepository;
import com.rota46.repository.ResourceNotFoundException;
import com.rota46.model.Cliente;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	// lista de clientes
	@GetMapping("/clientes")
	public List<Cliente> getAllClientes(){
	return clienteRepository.findAll();
	}
	
	// novo cliente rest api
	@PostMapping("/clientes")
	public Cliente adicionarCliente(@RequestBody Cliente cliente) {
	return clienteRepository.save(cliente);
	}
	
	// consulta cliente por id
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> consultaClienteId(@PathVariable Long id){
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente id " + id +" não existe:"));
		return ResponseEntity.ok(cliente);
	}
	
	// consulta cliente pelo nome ou parte dele
	@GetMapping("/clientesnome/{nome}")
	public List<Cliente> getAllClientesNome(@PathVariable String nome){
		return clienteRepository.findByNomeContainingIgnoreCase(nome);
	}
	
	
	
	// editar cliente rest api
	@PutMapping("/clientes/{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteDetails){
		Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id + " não foi encontrado."));
	
		cliente.setNome(clienteDetails.getNome());
		cliente.setTelefone(clienteDetails.getTelefone());
		cliente.setCPF(clienteDetails.getCpf());
		cliente.setSexo(clienteDetails.getSexo());
		cliente.setIdade(clienteDetails.getIdade());
	
		Cliente updatedCliente = clienteRepository.save(cliente);
		return ResponseEntity.ok(updatedCliente);
	}
	
	// delete cliente rest api
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCliente(@PathVariable Long id){
		Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id " + id + " não foi encontrado."));
		clienteRepository.delete(cliente);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
