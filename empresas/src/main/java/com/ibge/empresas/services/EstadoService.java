package com.ibge.empresas.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ibge.empresas.controller.dto.EstadoDto;

@Service
public class EstadoService {

	public List<EstadoDto> consultaEstados()
	{
		RestTemplate cliente = new RestTemplate();
		ResponseEntity<EstadoDto[]> response = cliente.getForEntity("https://servicodados.ibge.gov.br/api/v1/localidades/estados", EstadoDto[].class);
		
		EstadoDto[] estados = response.getBody();
		
		return Arrays.asList(estados);
	}
}
