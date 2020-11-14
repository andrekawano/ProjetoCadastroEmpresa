package com.ibge.empresas.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.ibge.empresas.modelo.Empresa;

public class EmpresaDto {

	private Long id;
	private String nome;
	private int quantidadeFuncionario;
	private double faturamento;
	private String estado;
	private String municipio;

	public EmpresaDto(Empresa empresa) {
		this.id = empresa.getId();
		this.nome = empresa.getNome();
		this.quantidadeFuncionario = empresa.getQuantidadeFuncionario();
		this.faturamento = empresa.getFaturamento();
		this.estado = empresa.getEstado();
		this.municipio = empresa.getMunicipio();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getQuantidadeFuncionario() {
		return quantidadeFuncionario;
	}
	
	public double getFaturamento() {
		return faturamento;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public String getMunicipio() {
		return municipio;
	}
	
	public static List<EmpresaDto> converter(List<Empresa> empresas){
		return empresas.stream().map(EmpresaDto::new).collect(Collectors.toList());
	}

	
}