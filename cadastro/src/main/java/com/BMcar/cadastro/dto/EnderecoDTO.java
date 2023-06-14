package com.BMcar.cadastro.dto;

import com.BMcar.cadastro.entities.Endereco;

public class EnderecoDTO {

	private Long id;
	private String rua;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String uf;
	private String pais;

	public EnderecoDTO() {

	}

	public EnderecoDTO(Long id, String rua, Integer numero, String bairro, String cidade, String uf, String pais) {
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.pais = pais;
	}

	public EnderecoDTO(Endereco entity) {
		id = entity.getId();
		rua = entity.getRua();
		numero = entity.getNumero();
		bairro = entity.getBairro();
		cidade = entity.getCidade();
		uf = entity.getUf();
		pais = entity.getPais();
	}

	public Long getId() {
		return id;
	}

	public String getRua() {
		return rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getUf() {
		return uf;
	}

	public String getPais() {
		return pais;
	}

}
