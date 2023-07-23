package com.BMcar.cadastro.dto;

import com.BMcar.cadastro.entities.Orcamentos;

public class OrcamentosDTO {

	private Long id;
	private String defeitoRelatado;
	private String diagnosticoTecnico;
	private String image01;
	private String image02;
	
	public OrcamentosDTO() {
		
	}

	public OrcamentosDTO(Long id, String defeitoRelatado, String diagnosticoTecnico, String image01,
			String image02) {
		
		this.id = id;
		this.defeitoRelatado = defeitoRelatado;
		this.diagnosticoTecnico = diagnosticoTecnico;
		this.image01 = image01;
		this.image02 = image02;
	}
	
	public OrcamentosDTO(Orcamentos entity) {
		id = entity.getId();
		defeitoRelatado = entity.getDefeitoRelatado();
		diagnosticoTecnico = entity.getDiagnosticoTecnico();
		image01 = entity.getImage01();
		image02 = entity.getImage02();
	}

	public Long getId() {
		return id;
	}

	public String getDefeitoRelatado() {
		return defeitoRelatado;
	}

	public String getDiagnosticoTecnico() {
		return diagnosticoTecnico;
	}

	public String getImage01() {
		return image01;
	}

	public String getImage02() {
		return image02;
	}
	
	
}
