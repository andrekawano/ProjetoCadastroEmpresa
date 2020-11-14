package com.ibge.empresas.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ibge.empresas.controller.dto.EmpresaDto;
import com.ibge.empresas.controller.formulario.EmpresaFormulario;
import com.ibge.empresas.modelo.Empresa;
import com.ibge.empresas.repository.EmpresaRepository;

@RestController
@RequestMapping("/empresas")
public class EmpresasController {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@GetMapping
	public List<EmpresaDto> lista()
	{
		List<Empresa> empresas = empresaRepository.findAll();
		
		return EmpresaDto.converter(empresas); 
	}
	
	@GetMapping("/{id}")
	public EmpresaDto buscaPorId(@PathVariable Long id) 
	{
		Empresa empresa = empresaRepository.getOne(id);
		
		return new EmpresaDto(empresa);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<EmpresaDto> incluir(@RequestBody EmpresaFormulario empresaFormulario, UriComponentsBuilder uriBuilder)
	{
		Empresa empresa = empresaFormulario.converter();
		empresaRepository.save(empresa);
		
		URI uri = uriBuilder.path("/empresas/{id}").buildAndExpand(empresa.getId()).toUri(); 
		return ResponseEntity.created(uri).body(new EmpresaDto(empresa));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EmpresaDto> atualizar(@PathVariable Long id, @RequestBody EmpresaFormulario empresaFormulario)
	{
		Empresa empresa = empresaFormulario.atualizar(id, empresaRepository);
		return ResponseEntity.ok(new EmpresaDto(empresa));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> excluir(@PathVariable Long id)
	{
		empresaRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	
}
