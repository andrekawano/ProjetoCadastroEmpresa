package com.ibge.empresas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import com.ibge.empresas.controller.EmpresasController;
import com.ibge.empresas.controller.dto.EmpresaDto;
import com.ibge.empresas.controller.formulario.EmpresaFormulario;
import com.ibge.empresas.modelo.Empresa;
import com.ibge.empresas.repository.EmpresaRepository;

import org.junit.platform.runner.JUnitPlatform;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class EmpresaControllerTeste {
	@InjectMocks
	EmpresasController empresaController;
	
	@Mock
	EmpresaRepository empresaRepository;
	
	@Test
	public void testeIncluirEmpresa() {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        //Arrange
        Empresa empresa = new Empresa("Empresa Teste",100,10000,"SAO PAULO","SAO PAULO");
        
        when(empresaRepository.save(any(Empresa.class))).thenReturn(empresa);
        
        EmpresaFormulario empresaFormulario = new EmpresaFormulario("Empresa Teste",100,10000,"SAO PAULO","SAO PAULO");
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance().scheme("http").host("localhost").path(""); 
        
        //Act
        ResponseEntity<EmpresaDto> responseEntity = empresaController.incluir(empresaFormulario, uriBuilder);

        //Assert
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity.getBody().getNome()).isEqualTo("Empresa Teste");
        }

	@Test
	public void testeListaEmpresa() {
		Empresa empresa = new Empresa("KAWANO INFORMATICA",100,10000,"SAO PAULO","SAO PAULO");
		List<Empresa> empresas = new ArrayList<>();
		empresas.add(empresa);
		
		when(empresaRepository.findAll()).thenReturn(empresas);
		
        //Act
        List<EmpresaDto> responseEntity = empresaController.lista();
        
        assertThat(responseEntity.get(0).getNome()).isEqualTo("KAWANO INFORMATICA");
		
	}
}
