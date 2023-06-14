package com.BMcar.cadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BMcar.cadastro.entities.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
	
	/* Camada Repository é quem realiza as operações "individuais" de acesso
	 * ao banco de dados. 
	 */

}
