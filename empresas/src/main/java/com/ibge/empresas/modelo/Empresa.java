package com.ibge.empresas.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empresa {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int quantidadeFuncionario;
	private double faturamento;
	private String estado;
	private String municipio;
	private LocalDateTime dataInclusao = LocalDateTime.now();
	
	public Empresa() {
	}

	public Empresa(String nome, int quantidadeFuncionario, double faturamento, String estado, String municipio) {
		super();
		this.nome = nome;
		this.quantidadeFuncionario = quantidadeFuncionario;
		this.faturamento = faturamento;
		this.estado = estado;
		this.municipio = municipio;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidadeFuncionario() {
		return quantidadeFuncionario;
	}
	public void setQuantidadeFuncionario(int quantidadeFuncionario) {
		this.quantidadeFuncionario = quantidadeFuncionario;
	}
	public double getFaturamento() {
		return faturamento;
	}
	public void setFaturamento(double faturamento) {
		this.faturamento = faturamento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicio(String municio) {
		this.municipio = municio;
	}
	
	

}
