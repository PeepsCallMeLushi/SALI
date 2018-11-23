package pt.sali.SALI.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

public class Atuacao {
	
	@Id
	private String id;
	private ArrayList<String> acao;
	private Transporte transporte;
	private String destino;
	private String naoTransporte;
	private String evolucao;
	private ArrayList<NomeParaSerAlterado> administrados;
	
	public Atuacao(Transporte transporte, String destino, String naoTransporte,
			String evolucao) {
		super();
		this.id = null;
		this.acao = new ArrayList<>();
		this.transporte = transporte;
		this.destino = destino;
		this.naoTransporte = naoTransporte;
		this.evolucao = evolucao;
		this.administrados = new ArrayList<>();
	}

	public Atuacao() {
		super();
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

	public ArrayList<NomeParaSerAlterado> getAdministrados() {
		return administrados;
	}

	public void setAdministrados(ArrayList<NomeParaSerAlterado> administrados) {
		this.administrados = administrados;
	}

	public String getId() {
		return id;
	}
	
}
