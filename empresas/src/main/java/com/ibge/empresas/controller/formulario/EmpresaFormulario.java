package com.ibge.empresas.controller.formulario;

import com.ibge.empresas.modelo.Empresa;
import com.ibge.empresas.repository.EmpresaRepository;

public class EmpresaFormulario {

	private String nome;
	private int quantidadeFuncionario;
	private double faturamento;
	private String estado;
	private String municipio;

	public EmpresaFormulario() {}
	
	public EmpresaFormulario(String nome, int quantidadeFuncionario, double faturamento, String estado,
			String municipio) {
		super();
		this.nome = nome;
		this.quantidadeFuncionario = quantidadeFuncionario;
		this.faturamento = faturamento;
		this.estado = estado;
		this.municipio = municipio;
	}

	public Empresa converter() {
		return new Empresa(nome,quantidadeFuncionario,faturamento,estado, municipio);
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

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public Empresa atualizar(Long id, EmpresaRepository empresaRepository) {
		Empresa empresa = empresaRepository.getOne(id);
		empresa.setNome(this.nome);
		empresa.setQuantidadeFuncionario(this.quantidadeFuncionario);
		empresa.setFaturamento(this.faturamento);
		empresa.setEstado(this.estado);
		empresa.setMunicio(this.municipio);
		return empresa;
	}

	
	
}
