package com.rota46.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Pacotes")
public class Pacote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "DataCompra", nullable = false)
	private String dataCompra;
	
	@Column(name = "DataViagem", nullable = false)
	private String dataViagem;
	
	@Column(name = "Preco", nullable = false)
	private float preco;
	
	@ManyToOne 
	@JoinColumn(name = "id_cliente", nullable = true)
	private Cliente cliente;
	
	@ManyToOne 
	@JoinColumn(name = "id_destino", nullable = true)
	private Destino destino;
	
	public Pacote() {

	}

	public Pacote(Long id, String dataCompra, String dataViagem, float preco,
			Cliente cliente, Destino destino) {
		super();
		this.id = id;
		this.dataCompra = dataCompra;
		this.dataViagem = dataViagem;
		this.preco = preco;
		this.cliente = cliente;
		this.destino = destino;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}

	public String getDataViagem() {
		return dataViagem;
	}

	public void setDataViagem(String dataViagem) {
		this.dataViagem = dataViagem;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}
	


}
