package com.BMcar.cadastro.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Orcamentos {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
	 private String defeitoRelatado;
	 private String diagnosticoTecnico;
	 private String image01;
	 private String image02;

	 @ManyToOne
	@JoinColumn(name = "veiculo_id")
	private Veiculo veiculo;

	 @ManyToOne
	@JoinColumn(name = "tecnico_id")
	private Tecnicos tecnico;

     public Orcamentos() {
		
	}

	public Orcamentos(Long id, String defeitoRelatado, String diagnosticoTecnico, String image01,
			String image02) {
		
		this.id = id;
		this.defeitoRelatado = defeitoRelatado;
		this.diagnosticoTecnico = diagnosticoTecnico;
		this.image01 = image01;
		this.image02 = image02;
	}

	
	public String getDefeitoRelatado() {
		return defeitoRelatado;
	}

	public void setDefeitoRelatado(String defeitoRelatado) {
		this.defeitoRelatado = defeitoRelatado;
	}

	public String getDiagnosticoTecnico() {
		return diagnosticoTecnico;
	}

	public void setDiagnosticoTecnico(String diagnosticoTecnico) {
		this.diagnosticoTecnico = diagnosticoTecnico;
	}

	public String getImage01() {
		return image01;
	}

	public void setImage01(String image01) {
		this.image01 = image01;
	}

	public String getImage02() {
		return image02;
	}

	public void setImage02(String image02) {
		this.image02 = image02;
	}

	public Long getId() {
		return id;
	}

}
