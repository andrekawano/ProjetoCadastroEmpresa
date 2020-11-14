package com.ibge.empresas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibge.empresas.modelo.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
}
