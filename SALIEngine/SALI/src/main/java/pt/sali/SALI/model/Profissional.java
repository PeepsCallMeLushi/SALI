package pt.sali.SALI.model;

import org.springframework.data.annotation.Id;

public class Profissional {

	@Id
	private String id;
	private String nome;
	private String cedula;
	private String nmrINEM;
	private String area;
	private String especializacao;
	
	public Profissional(String nome, String cedula, String nmrINEM, String area, String especializacao) {
		super();
		this.id = null;
		this.nome = nome;
		this.cedula = cedula;
		this.nmrINEM = nmrINEM;
		this.area = area;
		this.especializacao = especializacao;
	}

	public Profissional() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNmrINEM() {
		return nmrINEM;
	}

	public void setNmrINEM(String nmrINEM) {
		this.nmrINEM = nmrINEM;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}

	public String getId() {
		return id;
	}
	
}
