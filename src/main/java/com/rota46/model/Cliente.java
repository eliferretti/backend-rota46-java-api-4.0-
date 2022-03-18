package com.rota46.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Nome", nullable = false)
	private String nome;
	
	@Column(name = "Telefone", nullable = false) 
	private String telefone;
	
	@Column(name = "CPF", nullable = false)
	private String cpf;
	
	@Column(name = "Sexo", nullable = false)
	private String sexo;
	
	@Column(name = "Idade", nullable = false)
	private Long idade;

	@OneToMany(mappedBy = "cliente")
	private List<Pacote> pacotes;

	public Cliente() {
		
	}
	
	public Cliente(String nome, String telefone, String cpf, String sexo, Long idade) {

		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.sexo = sexo;
		this.idade = idade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCPF(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}	
	
}
