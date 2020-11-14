package com.ibge.empresas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibge.empresas.controller.dto.EstadoDto;
import com.ibge.empresas.services.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadosController {

	@Autowired
	private EstadoService estadoService; 
	
	@GetMapping
	public List<EstadoDto> lista()
	{
		
		return estadoService.consultaEstados(); 
	}
}
