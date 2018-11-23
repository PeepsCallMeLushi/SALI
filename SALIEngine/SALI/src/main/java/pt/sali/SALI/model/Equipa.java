package pt.sali.SALI.model;

public class Equipa {

	private Utilizador medico;
	private Utilizador enfermeiro;
	
	public Equipa(Utilizador medico, Utilizador enfermeiro) {
		super();
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
}
