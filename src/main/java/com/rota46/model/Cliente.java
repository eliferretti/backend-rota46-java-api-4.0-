package com.rota46.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Nome", nullable = false)
	private String Nome;
	
	@Column(name = "Telefone", nullable = false) 
	private String Telefone;
	
	@Column(name = "CPF", nullable = false)
	private String CPF;
	
	@Column(name = "Sexo", nullable = false)
	private String Sexo;
	
	@Column(name = "Idade", nullable = false)
	private Long Idade;
	

	public Cliente() {
		
	}
	
	public Cliente(Long id, String nome, String telefone, String cPF, String sexo, Long idade) {
		super();
		this.id = id;
		Nome = nome;
		Telefone = telefone;
		CPF = cPF;
		Sexo = sexo;
		Idade = idade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	public Long getIdade() {
		return Idade;
	}

	public void setIdade(Long idade) {
		Idade = idade;
	}	
	
}
