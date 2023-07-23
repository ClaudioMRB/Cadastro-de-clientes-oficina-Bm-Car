package com.BMcar.cadastro.dto;

import com.BMcar.cadastro.entities.Cliente;

public class ClienteDTO {

	/* Objeto simples para transferência de dados (Data Transfer Object) */

	private Long id;
	private String nome;
	private String cpf;
	private String email;
	private String senha;

	public ClienteDTO() {

	}

	public ClienteDTO(Cliente entity) {
		id = entity.getId();
		nome = entity.getNome();
		cpf = entity.getCpf();
		email = entity.getEmail();
		senha = entity.getSenha();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	
	
	
	
}