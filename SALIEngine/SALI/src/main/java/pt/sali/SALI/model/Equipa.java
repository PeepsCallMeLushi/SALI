package pt.sali.SALI.model;

import org.springframework.data.annotation.Id;

public class Equipa {
	
	@Id
	private String id;
	private Profissional medico;
	private Profissional enfermeiro;
	
	public Equipa(String id, Profissional medico, Profissional enfermeiro) {
		super();
		this.id = id;
		this.medico = medico;
		this.enfermeiro = enfermeiro;
	}

	public Equipa() {
		super();
	}

	public Profissional getMedico() {
		return medico;
	}

	public void setMedico(Profissional medico) {
		this.medico = medico;
	}

	public Profissional getEnfermeiro() {
		return enfermeiro;
	}

	public void setEnfermeiro(Profissional enfermeiro) {
		this.enfermeiro = enfermeiro;
	}

	public String getId() {
		return id;
	}

}
