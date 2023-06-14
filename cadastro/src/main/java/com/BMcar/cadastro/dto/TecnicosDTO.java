package com.BMcar.cadastro.dto;

import com.BMcar.cadastro.entities.Tecnicos;

public class TecnicosDTO {

	private Long id;
	private String nome;
	
	
	public TecnicosDTO() {
		
	}


	/*public TecnicosDTO(Long id, String nome) {
		
		this.id = id;
		this.nome = nome;
	}*/
	
	public TecnicosDTO(Tecnicos entity) {
		id = entity.getId();
		nome = entity.getNome();
	}


	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}
	
	
	
}
