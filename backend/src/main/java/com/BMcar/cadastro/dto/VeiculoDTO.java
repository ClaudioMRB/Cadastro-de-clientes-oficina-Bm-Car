package com.BMcar.cadastro.dto;

import com.BMcar.cadastro.entities.Veiculo;

public class VeiculoDTO {

	private Long id;
	private String carro;
	private String cor;
	private Integer cc;
	private String ano;
	private String fabricante;
	
	public VeiculoDTO() {
		
	}

	public VeiculoDTO(Long id, String nome, String cor, Integer cc, String ano, String fabricante) {
		this.id = id;
		this.carro = nome;
		this.cor = cor;
		this.cc = cc;
		this.ano = ano;
		this.fabricante = fabricante;
	}
	
	public VeiculoDTO(Veiculo entity) {
		id = entity.getId();
		carro = entity.getCarro();
		cor = entity.getCor();
		cc = entity.getCc();
		ano = entity.getAno();
		fabricante = entity.getFabricante();
	}

	public Long getId() {
		return id;
	}



	public String getCarro() {
		return carro;
	}

	

	public String getCor() {
		return cor;
	}


	public Integer getCc() {
		return cc;
	}

	
	public String getAno() {
		return ano;
	}



	public String getFabricante() {
		return fabricante;
	}

	
	
	
	
}
