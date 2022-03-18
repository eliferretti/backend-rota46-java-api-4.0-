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
@Table(name = "Destinos")
public class Destino {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long   id;
	
	@Column(name = "Titulo", nullable = false)
	private String titulo;
	
	@Column(name = "Descricao", nullable = false)
	private String descricao;
	
	@Column(name = "Tipo", nullable = false)
	private String tipo;
	
	@Column(name = "Promo", nullable = false)
	private String promo;
	
	@Column(name = "Preco", nullable = false)
	private Float  preco;
	
	
	@OneToMany(mappedBy = "destino")
	private List<Pacote> pacotes;

	
	public Destino() {

	}
	
	public Destino(Long id, String titulo, String descricao, String tipo, String promo, Float preco) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.tipo = tipo;
		this.promo = promo;
		this.preco = preco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPromo() {
		return promo;
	}

	public void setPromo(String promo) {
		this.promo = promo;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	} 

}


