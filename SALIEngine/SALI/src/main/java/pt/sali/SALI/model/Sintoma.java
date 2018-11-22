package pt.sali.SALI.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

public class Sintoma {
	
	@Id
	private String id;
	private String metodologia;
	private String nome;
	private ArrayList<Pergunta> pergunta;
	
	public Sintoma(String metodologia, String nome, ArrayList<Pergunta> pergunta) {
		super();
		this.id = null;
		this.metodologia = metodologia;
		this.nome = nome;
		this.pergunta = pergunta;
	}

	public Sintoma() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Pergunta> getPergunta() {
		return pergunta;
	}

	public void setPergunta(ArrayList<Pergunta> pergunta) {
		this.pergunta = pergunta;
	}

	public String getId() {
		return id;
	}
	
}
