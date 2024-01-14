package com.apirest.viveiro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "planta")
public class PlantaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "quantidade")
	private Integer quantidade;
	
	@Column(name = "tem_fruta")
	private Boolean temFruta;
	
	@Column(name = "frequencia_regagem")
	private Integer frequenciaRegagem;
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Boolean getTemFruta() {
		return this.temFruta;
	}
	
	public void setTemFruta(Boolean temFruta) {
		this.temFruta = temFruta;
	}
	
	public Integer getFrequenciaRegagem() {
		return this.frequenciaRegagem;
	}
	
	public void setFrequenciaRegagem(Integer frequenciaRegagem) {
		this.frequenciaRegagem = frequenciaRegagem;
	}
	
	public Integer getQuantidade() {
		return this.quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}
