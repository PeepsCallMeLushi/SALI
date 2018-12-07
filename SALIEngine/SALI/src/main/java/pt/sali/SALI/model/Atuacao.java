package pt.sali.SALI.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Atuacao {

	private ArrayList<String> acao;
	private Transporte transporte;
	private String destino;
	private String naoTransporte;
	private String evolucao;
	private ArrayList<FarmaFluido> administrados;
	@JsonProperty
	private boolean ambulanciaNoLocal;
	
	public Atuacao(Transporte transporte, String destino, String naoTransporte,
			String evolucao, boolean ambulanciaNoLocal) {
		super();
		this.acao = new ArrayList<>();
		this.transporte = transporte;
		this.destino = destino;
		this.naoTransporte = naoTransporte;
		this.evolucao = evolucao;
		this.administrados = new ArrayList<>();
		this.ambulanciaNoLocal = ambulanciaNoLocal;
	}

	public Atuacao() {
		super();
		this.acao = new ArrayList<>();
		this.administrados = new ArrayList<>();
	}

	public ArrayList<String> getAcao() {
		return acao;
	}

	public void setAcao(ArrayList<String> acao) {
		this.acao = acao;
	}

	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getNaoTransporte() {
		return naoTransporte;
	}

	public void setNaoTransporte(String naoTransporte) {
		this.naoTransporte = naoTransporte;
	}

	public String getEvolucao() {
		return evolucao;
	}

	public void setEvolucao(String evolucao) {
		this.evolucao = evolucao;
	}

	public ArrayList<FarmaFluido> getAdministrados() {
		return administrados;
	}

	public void setAdministrados(ArrayList<FarmaFluido> administrados) {
		this.administrados = administrados;
	}

	public boolean isAmbulanciaNoLocal() {
		return ambulanciaNoLocal;
	}

	public void setAmbulanciaNoLocal(boolean ambulanciaNoLocal) {
		this.ambulanciaNoLocal = ambulanciaNoLocal;
	}
}
