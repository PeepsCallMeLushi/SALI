package pt.sali.SALI.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sintoma {
	
	@Id
	private String id;
	private String metodologia;
	private String nome;
	@JsonProperty
	private boolean corpoSelecionado;
	private ArrayList<String> partesAfetadas;
	private ArrayList<Pergunta> pergunta;
	
	public Sintoma(String metodologia, String nome, boolean corpoSelecionado) {
		super();
		this.metodologia = metodologia;
		this.nome = nome;
		this.corpoSelecionado = corpoSelecionado;
		this.partesAfetadas = new ArrayList<>();
		this.pergunta = new ArrayList<>();
	}

	public Sintoma() {
		super();
		this.partesAfetadas = new ArrayList<>();
		this.pergunta = new ArrayList<>();
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

	public String getMetodologia() {
		return metodologia;
	}

	public void setMetodologia(String metodologia) {
		this.metodologia = metodologia;
	}

	public boolean isCorpoSelecionado() {
		return corpoSelecionado;
	}

	public void setCorpoSelecionado(boolean corpoSelecionado) {
		this.corpoSelecionado = corpoSelecionado;
	}

	public ArrayList<String> getPartesAfetadas() {
		return partesAfetadas;
	}

	public void setPartesAfetadas(ArrayList<String> partesAfetadas) {
		this.partesAfetadas = partesAfetadas;
	}
}
