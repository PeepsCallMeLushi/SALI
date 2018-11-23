package pt.sali.SALI.model;

import org.springframework.data.annotation.Id;

public class Equipa {
	
	@Id
	private String id;
	private Utilizador medico;
	private Utilizador enfermeiro;
	
	public Equipa(String id, Utilizador medico, Utilizador enfermeiro) {
		super();
		this.id = id;
		this.medico = medico;
		this.enfermeiro = enfermeiro;
	}

	public Equipa() {
		super();
	}

	public Utilizador getMedico() {
		return medico;
	}

	public void setMedico(Utilizador medico) {
		this.medico = medico;
	}

	public Utilizador getEnfermeiro() {
		return enfermeiro;
	}

	public void setEnfermeiro(Utilizador enfermeiro) {
		this.enfermeiro = enfermeiro;
	}

	public String getId() {
		return id;
	}

}
