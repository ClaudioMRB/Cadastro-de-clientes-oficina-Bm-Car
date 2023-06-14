package com.BMcar.cadastro.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BMcar.cadastro.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	/* Camada Repository é quem realiza as operações "individuais" de acesso
	 * ao banco de dados. 
	 */

	public Optional<Cliente> findByEmail(String email);
	
}
